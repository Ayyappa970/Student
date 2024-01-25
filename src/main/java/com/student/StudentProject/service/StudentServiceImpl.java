package com.student.StudentProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentProject.dto.StudentDto;
import com.student.StudentProject.entity.Student;
import com.student.StudentProject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	@Override
	public long addStudent(Student std) {
		Student student = repo.findBystdRollNo(std.getStdRollNo());
		if (student!=null) {
			return student.getStdId();
		} else {
			Student save = repo.save(Student.builder().stdName(std.getStdName()).stdRollNo(std.getStdRollNo()).stdStream(std.getStdStream())
					.stdEmail(std.getStdEmail()).stdMobileNo(std.getStdMobileNo()).build());
			return save.getStdId();
		}
	}
	@Override
	public long deleteStudent(String rollNo) {
		Student student = repo.findBystdRollNo(rollNo);
		try {
			if (student!=null) {
				repo.deleteById(student.getStdId());
				return 1;
			}else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	@Override
	public Student updateStudent(String rollNo, StudentDto dto) {
		Student student = repo.findBystdRollNo(rollNo);
		try {
			if (student!=null) {
				student.setStdName(dto.getStdName());
				student.setStdRollNo(dto.getStdRollNo());
				student.setStdStream(dto.getStdStream());
				student.setStdEmail(dto.getStdEmail());
				student.setStdMobileNo(dto.getStdMobileNo());
				Student save = repo.save(student);
				return save;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public StudentDto fetchStudent(String rollNo) {
		Student student = repo.findBystdRollNo(rollNo);
		try {
			if (student!=null) {
				return	StudentDto.builder().stdName(student.getStdName()).stdRollNo(rollNo).stdStream(student.getStdStream())
						.stdEmail(student.getStdEmail()).stdMobileNo(student.getStdMobileNo()).build();
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<StudentDto> fetchAllStudents() {
		List<Student> all = repo.findAll();
		try {
			if (all!=null) {
				return all.stream().map(t->StudentDto.builder().stdName(t.getStdName()).stdRollNo(t.getStdRollNo()).stdStream(t.getStdStream())
						.stdEmail(t.getStdEmail()).stdMobileNo(t.getStdMobileNo()).build()).collect(Collectors.toList());
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
