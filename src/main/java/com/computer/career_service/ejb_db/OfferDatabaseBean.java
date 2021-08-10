/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.ejb_db;

import com.computer.career_service.entities.Company;
import com.computer.career_service.entities.Offer;
import com.lenny.my_shop_web_backend.jpa.TransactionProvider;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class OfferDatabaseBean {

    @EJB
    TransactionProvider transactionProvider;

    public List<Offer> getAllOffers() {
        List offerList = new ArrayList();
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT o FROM Offer o");
            offerList = transactionProvider.getManyFromQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return offerList;
        }
    }

    public List<Offer> getRoleOffer_ByCompanyId(Integer companyId) {
        List offerList = new ArrayList();
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT o FROM Offer o WHERE o.companyId.id = :companyId");
            query.setParameter("companyId", companyId);
            offerList = transactionProvider.getManyFromQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return offerList;
        }
    }

    public Offer getOffer_ByOfferId(Integer offerId) {
        Offer offer = null;
        try {
            EntityManager entityManager = transactionProvider.getEM();
            Query query = entityManager.createQuery("SELECT o FROM Offer o WHERE o.id = :offerId");
            query.setParameter("offerId", offerId);
            offer = transactionProvider.getSingleResult(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return offer;
        }
    }

}
