/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb;

import com.computer.career_service.ejb_db.CompanyDatabaseBean;
import com.computer.career_service.entities.Company;
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
public class CompanyBean {

    @EJB
    TransactionProvider provider;

    @EJB
    private CompanyDatabaseBean companyDatabaseBean;

    public Response getAllCompanies() {
        try {
            List<Company> companyList = companyDatabaseBean.getAllCompanies();
            HashMap<String, Object> res = new HashMap<>();
            if (companyList.isEmpty()) {
                res.put("companies", companyList);
                res.put("Message", "No companies exist");
            } else {
                List<Object> companies = new ArrayList<>();
                for (Company company : companyList) {
                    HashMap<String, Object> companyHashMap = new HashMap<>();
                    companyHashMap.put("id", company.getId());
                    companyHashMap.put("name", company.getName());
                    companyHashMap.put("contactName", company.getContactPersonName());
                    companyHashMap.put("contactPhone", company.getContactPersonPhone());
                    companies.add(companyHashMap);
                }
                res.put("companies", companies);
                res.put("Message", "All companies fetched successfully");
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

}
