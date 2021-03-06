package com.great.cms.db.dao;

import com.great.cms.db.entity.Student;

public interface StudentDao extends GenericDao<Student, Integer> {

	public Student getStudentByReg(Integer reg);

}
