package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;
import com.student.demo.service.IdAlreadyExistException;
import com.student.demo.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody  Student student) {
		studentService.createStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);	
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<Student> readStudent(@PathVariable  int id) {
		Student readStudent = studentService.readStudent(id);
		return new ResponseEntity<Student>(readStudent,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> studentList(){
		List<Student> studentList = studentService.studentList();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(Student student, int id){
		Student updateStudent = studentService.updateStudent(student, id);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.TEMPORARY_REDIRECT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(int id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Selected student deleted",HttpStatus.GONE);
	}
}
