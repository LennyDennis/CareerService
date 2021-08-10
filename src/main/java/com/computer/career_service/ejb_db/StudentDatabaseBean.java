/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb_db;

import com.computer.career_service.entities.Offer;
import com.computer.career_service.entities.Student;
import com.lenny.my_shop_web_backend.jpa.TransactionProvider;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class StudentDatabaseBean {

    @EJB
    TransactionProvider transactionProvider;

    public List<Student> getAllStudent() {
        List studenList = new ArrayList();
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT s FROM Student s");
            studenList = transactionProvider.getManyFromQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return studenList;
        }
    }

    public Student getStudent_ById(Integer studentId) {
        Student student = null;
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id = :studentId");
            query.setParameter("studentId", studentId);
            student = transactionProvider.getSingleResult(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return student;
        }
    }

}
