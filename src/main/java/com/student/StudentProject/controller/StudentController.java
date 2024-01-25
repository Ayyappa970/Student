package com.student.StudentProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.StudentProject.dto.StudentDto;
import com.student.StudentProject.entity.Student;
import com.student.StudentProject.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;

	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student std) {
		long l = service.addStudent(std);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data Inserted Successfully id is : "+l);
	}

	@DeleteMapping("/deleteStudent/{roll}")
	public ResponseEntity<String> deleteStudent(@PathVariable("roll") String rollNo) {
		long l = service.deleteStudent(rollNo);
		if (l>0) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Data deleted Successfully id is : "+l);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found by id is : "+l);
		}
	}

	@PutMapping("/updateStudent/{roll}")
	public ResponseEntity<String> updateStudent(@PathVariable("roll") String rollNo,@RequestBody StudentDto dto) {
		Student student = service.updateStudent(rollNo, dto);
		if (student!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Data updated Successfully id is : "+rollNo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found by id is : "+rollNo);
		}
	}

	@GetMapping("/getStudent/{roll}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("roll") String rollNo) {
		StudentDto dto = service.fetchStudent(rollNo);
		if (dto!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(dto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> list = service.fetchAllStudents();
		if (list!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
