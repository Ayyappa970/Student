package com.student.StudentProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StudentDto {
	private String stdName;
	private String stdRollNo;
	private String stdStream;
	private String stdEmail;
	private long stdMobileNo;
}
