package com.computer.career_service.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, String> contactPersonName;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile ListAttribute<Company, Offer> offerList;
	public static volatile SingularAttribute<Company, Integer> id;
	public static volatile SingularAttribute<Company, String> contactPersonPhone;

	public static final String CONTACT_PERSON_NAME = "contactPersonName";
	public static final String NAME = "name";
	public static final String OFFER_LIST = "offerList";
	public static final String ID = "id";
	public static final String CONTACT_PERSON_PHONE = "contactPersonPhone";

}

