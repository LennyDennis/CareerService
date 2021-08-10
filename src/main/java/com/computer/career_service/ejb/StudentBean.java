/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb;

import com.computer.career_service.ejb_db.OfferDatabaseBean;
import com.computer.career_service.ejb_db.StudentDatabaseBean;
import com.computer.career_service.entities.Offer;
import com.computer.career_service.entities.RolesOffered;
import com.computer.career_service.entities.Student;
import static com.computer.career_service.utilities.ConstantVariables.OFFER_OFF;
import com.lenny.my_shop_web_backend.jpa.TransactionProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

@Stateless
public class StudentBean {

    @EJB
    TransactionProvider provider;

    @EJB
    private StudentDatabaseBean studentDatabaseBean;

    @EJB
    private OfferDatabaseBean offerDatabaseBean;

    public Response getAllStudents() {
        try {
            List<Student> studentList = studentDatabaseBean.getAllStudent();
            HashMap<String, Object> res = new HashMap<>();
            if (studentList.isEmpty()) {
                res.put("students", studentList);
                res.put("Message", "No Offers exist exist");
            } else {
                List students = new ArrayList<>();
                for (Student student : studentList) {
                    HashMap<String, Object> studentHashMap = new HashMap<>();
                    studentHashMap.put("id", student.getId());
                    studentHashMap.put("name", student.getName());
                    studentHashMap.put("course", student.getCourseId().getName());
                    studentHashMap.put("offerType", student.getOfferType());
                    students.add(studentHashMap);
                }
                res.put("students", students);
                res.put("Message", "All students fetched successfully");
            }
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    public Response addStudent(Student newStudent) {
        try {
            if (newStudent == null) {
                throw new BadRequestException("Student is empty");
            }
            newStudent.setOfferStatus(OFFER_OFF);
            if (!provider.createEntity(newStudent)) {
                throw new PersistenceException("Student has not been saved successfully");
            }
            HashMap<String, Object> res = new HashMap<>();
            res.put("Message", "Student " + newStudent.getName() + " has been created");
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    public Response addStudent_toRole(Integer studentId, Integer offerId) {
        try {
            Student student = studentDatabaseBean.getStudent_ById(studentId);
            Offer offer = offerDatabaseBean.getOffer_ByOfferId(offerId);
            if (student == null || offer == null) {
                throw new BadRequestException("Student or Offer missing");
            }
            RolesOffered newRoleOffered = new RolesOffered();
            newRoleOffered.setRoleId(offer);
            newRoleOffered.setStudentId(student);
            if (!provider.createEntity(newRoleOffered)) {
                throw new PersistenceException("Student not assigned to role successfully");
            }
            HashMap<String, Object> res = new HashMap<>();
            res.put("Message", "Student not assigned to role successfully");
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    public Response editStudent(Student newStudent) {
        try {
            if (newStudent == null) {
                throw new BadRequestException("Student is empty");
            }
            newStudent.setOfferStatus(OFFER_OFF);
            if (!provider.updateEntity(newStudent)) {
                throw new PersistenceException("Student has not been updated successfully");
            }
            HashMap<String, Object> res = new HashMap<>();
            res.put("Message", "Student " + newStudent.getName() + " has been created");
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    public Response deleteStudent(Integer studentId) {
        try {
            if (studentId == null) {
                throw new BadRequestException("Student Id is empty");
            }
            Student student = studentDatabaseBean.getStudent_ById(studentId);
            if (!provider.deleteEntity(student)) {
                throw new PersistenceException("Student has been not been deleted successfully");
            }
            HashMap<String, Object> res = new HashMap<>();
            res.put("Message", "Student has been deleted");
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (PersistenceException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

}
