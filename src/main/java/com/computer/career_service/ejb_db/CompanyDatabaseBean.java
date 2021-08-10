/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb_db;

import com.computer.career_service.entities.Company;
import com.lenny.my_shop_web_backend.jpa.TransactionProvider;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class CompanyDatabaseBean {

    @EJB
    TransactionProvider transactionProvider;

    public List<Company> getAllCompanies() {
        List companyList = new ArrayList();
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT c FROM Company c");
            companyList = transactionProvider.getManyFromQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return companyList;
        }
    }

}
