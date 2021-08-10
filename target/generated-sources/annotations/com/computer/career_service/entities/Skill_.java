package com.computer.career_service.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Skill.class)
public abstract class Skill_ {

	public static volatile SingularAttribute<Skill, Offer> offerId;
	public static volatile SingularAttribute<Skill, Integer> id;
	public static volatile SingularAttribute<Skill, Course> courseId;

	public static final String OFFER_ID = "offerId";
	public static final String ID = "id";
	public static final String COURSE_ID = "courseId";

}

