package com.computer.career_service.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile ListAttribute<Course, Skill> skillList;
	public static volatile SingularAttribute<Course, String> name;
	public static volatile ListAttribute<Course, Student> studentList;
	public static volatile SingularAttribute<Course, Integer> id;

	public static final String SKILL_LIST = "skillList";
	public static final String NAME = "name";
	public static final String STUDENT_LIST = "studentList";
	public static final String ID = "id";

}

