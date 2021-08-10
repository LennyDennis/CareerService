/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb;

import com.computer.career_service.ejb_db.CompanyDatabaseBean;
import com.computer.career_service.ejb_db.OfferDatabaseBean;
import com.computer.career_service.entities.Company;
import com.computer.career_service.entities.Offer;
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
public class OfferBean {

    @EJB
    TransactionProvider provider;

    @EJB
    private OfferDatabaseBean offerDatabaseBean;

    public Response getAllOffers() {
        try {
            List<Offer> offerList = offerDatabaseBean.getAllOffers();
            HashMap<String, Object> res = new HashMap<>();
            if (offerList.isEmpty()) {
                res.put("offers", offerList);
                res.put("Message", "No Offers exist exist");
            } else {
                List offers = new ArrayList<>();
                for (Offer offer : offerList) {
                    HashMap<String, Object> offerHashMap = new HashMap<>();
                    offerHashMap.put("id", offer.getId());
                    offerHashMap.put("company", offer.getCompanyId().getName());
                    offerHashMap.put("description", offer.getDescription());
                    offerHashMap.put("offerType", offer.getOfferType());
                    offerHashMap.put("numberRequired", offer.getNumberRequired());
                    offerHashMap.put("placeOfWork", offer.getPlaceOfWork());
                    offerHashMap.put("applicationDate", offer.getApplicationDate());
                    offerHashMap.put("startDate", offer.getStartDate());
                    offerHashMap.put("endDate", offer.getEndDate());
                    offers.add(offerHashMap);
                }
                res.put("offers", offers);
                res.put("Message", "All offers fetched successfully");
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

    public Response getOfferRoles_ByCompanyId(Integer companyId) {
        try {
            List<Offer> offerList = offerDatabaseBean.getRoleOffer_ByCompanyId(companyId);
            HashMap<String, Object> res = new HashMap<>();
            if (offerList.isEmpty()) {
                res.put("offers", offerList);
                res.put("Message", "No Offers exist exist");
            } else {
                List offers = new ArrayList<>();
                for (Offer offer : offerList) {
                    HashMap<String, Object> offerHashMap = new HashMap<>();
                    offerHashMap.put("id", offer.getId());
                    offerHashMap.put("company", offer.getCompanyId().getName());
                    offerHashMap.put("description", offer.getDescription());
                    offerHashMap.put("offerType", offer.getOfferType());
                    offerHashMap.put("numberRequired", offer.getNumberRequired());
                    offerHashMap.put("placeOfWork", offer.getPlaceOfWork());
                    offerHashMap.put("applicationDate", offer.getApplicationDate());
                    offerHashMap.put("startDate", offer.getStartDate());
                    offerHashMap.put("endDate", offer.getEndDate());
                    offers.add(offerHashMap);
                }
                res.put("offers", offers);
                res.put("Message", "All offers fetched successfully");
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
