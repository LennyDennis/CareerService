package com.computer.career_service.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Integer> offerType;
	public static volatile ListAttribute<Student, RolesOffered> rolesOfferedList;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, Integer> id;
	public static volatile SingularAttribute<Student, Course> courseId;
	public static volatile SingularAttribute<Student, Integer> offerStatus;

	public static final String OFFER_TYPE = "offerType";
	public static final String ROLES_OFFERED_LIST = "rolesOfferedList";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String COURSE_ID = "courseId";
	public static final String OFFER_STATUS = "offerStatus";

}

