package com.student.demo.service;

import java.util.List;

import com.student.demo.entity.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public Student readStudent(int id);
	public List<Student> studentList();
	public Student updateStudent(Student student, int id);
	public String deleteStudent(int id);
}
