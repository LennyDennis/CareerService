/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.api;

import com.computer.career_service.ejb.CompanyBean;
import com.computer.career_service.ejb.OfferBean;
import com.computer.career_service.ejb.StudentBean;
import com.computer.career_service.entities.Student;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/company")
@Produces({MediaType.APPLICATION_JSON})
public class StudentAPI {

    @EJB
    StudentBean studentBean;

    @EJB
    OfferBean offerBean;

    @POST
    public Response addStudent(Student student) {
        return studentBean.addStudent(student);
    }

    @POST
    @Path("/role")
    public Response addStudent_toRole(@QueryParam("studentId")Integer studentId,@QueryParam("roleId")Integer roleId) {
        return studentBean.addStudent_toRole(studentId,roleId);
    }
    
    @PUT
    public Response editStudent(Student student) {
        return studentBean.editStudent(student);
    }

    @DELETE
    public Response deleteStudent(@QueryParam("studentId")Integer studentId) {
        return studentBean.deleteStudent(studentId);
    }

    @GET
    public Response getAllStudents() {
        return studentBean.getAllStudents();
    }

}
