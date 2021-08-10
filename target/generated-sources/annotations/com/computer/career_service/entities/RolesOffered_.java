package com.computer.career_service.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RolesOffered.class)
public abstract class RolesOffered_ {

	public static volatile SingularAttribute<RolesOffered, Student> studentId;
	public static volatile SingularAttribute<RolesOffered, Offer> roleId;
	public static volatile SingularAttribute<RolesOffered, Integer> id;
	public static volatile SingularAttribute<RolesOffered, Integer> status;

	public static final String STUDENT_ID = "studentId";
	public static final String ROLE_ID = "roleId";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

