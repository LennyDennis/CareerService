/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.api;

import com.computer.career_service.ejb.CompanyBean;
import com.computer.career_service.ejb.OfferBean;
import com.computer.career_service.entities.Offer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/company")
@Produces({MediaType.APPLICATION_JSON})
public class CompanyAPI {
    
    @EJB
    CompanyBean companyBean;
    
    @EJB
    OfferBean offerBean;

    @GET
    public Response getAllCompanies() {
        return companyBean.getAllCompanies();
    }
    
    @POST
    @Path("role")
    public Response getRole_ByCompanyId(@QueryParam("companyId")Integer companyId) {
        return offerBean.getOfferRoles_ByCompanyId(companyId);
    }
    
    @GET
    @Path("allRoles")
    public Response getAllRoles() {
        return offerBean.getAllOffers();
    }
    
    
}
