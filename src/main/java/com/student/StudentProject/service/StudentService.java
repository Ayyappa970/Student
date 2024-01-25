package com.student.StudentProject.service;

import java.util.List;

import com.student.StudentProject.dto.StudentDto;
import com.student.StudentProject.entity.Student;

public interface StudentService {
	long addStudent(Student std);
	long deleteStudent(String rollNo);
	Student updateStudent(String rollNo,StudentDto std);
	StudentDto fetchStudent(String rollNo);
	List<StudentDto> fetchAllStudents();
}
