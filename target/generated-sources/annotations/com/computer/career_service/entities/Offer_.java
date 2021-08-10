package com.computer.career_service.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Offer.class)
public abstract class Offer_ {

	public static volatile SingularAttribute<Offer, Integer> offerType;
	public static volatile SingularAttribute<Offer, Company> companyId;
	public static volatile ListAttribute<Offer, RolesOffered> rolesOfferedList;
	public static volatile ListAttribute<Offer, Skill> skillList;
	public static volatile SingularAttribute<Offer, Integer> numberRequired;
	public static volatile SingularAttribute<Offer, Date> endDate;
	public static volatile SingularAttribute<Offer, String> placeOfWork;
	public static volatile SingularAttribute<Offer, String> description;
	public static volatile SingularAttribute<Offer, Integer> id;
	public static volatile SingularAttribute<Offer, Date> startDate;
	public static volatile SingularAttribute<Offer, Date> applicationDate;

	public static final String OFFER_TYPE = "offerType";
	public static final String COMPANY_ID = "companyId";
	public static final String ROLES_OFFERED_LIST = "rolesOfferedList";
	public static final String SKILL_LIST = "skillList";
	public static final String NUMBER_REQUIRED = "numberRequired";
	public static final String END_DATE = "endDate";
	public static final String PLACE_OF_WORK = "placeOfWork";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String START_DATE = "startDate";
	public static final String APPLICATION_DATE = "applicationDate";

}

