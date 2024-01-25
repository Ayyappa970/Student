package com.student.StudentProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.student.StudentProject.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT std FROM student std WHERE  std.stdRollNo =:RollNo")
	Student findBystdRollNo(@Param("RollNo") String rollNo);
}
