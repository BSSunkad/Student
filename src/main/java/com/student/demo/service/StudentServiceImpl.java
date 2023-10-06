package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student createStudent(Student student){
		Student student1 = studentRepo.save(student);

		String name = student.getName();
		String regName = "^[A-Z]{1,20}$";
		if (!name.matches(regName)) {
			
		}

		String phNo = student.getPhNo();
		String regPhNo = "^[\\+91]?[7-9][0-9]{9}$";
		if (!phNo.matches(regPhNo)) {

		}

		String email = student.getEmail();
		String regEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (!email.matches(regEmail)) {

		}

		String dOB = student.getDOB();
		String regDOB = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$";
		if (!dOB.matches(regDOB)) {

		}
		return student1;
	}

	@Override
	public Student readStudent(int id) {
		Optional<Student> student1 = studentRepo.findById(id);
		return student1.get();
	}

	@Override
	public List<Student> studentList() {
		List<Student> findAll = studentRepo.findAll();
		return findAll;
	}

	@Override
	public Student updateStudent(Student student, int id) {
		Student oldStudent = studentRepo.findById(student.getId()).get();
		oldStudent.setDOB(student.getDOB());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setId(student.getId());
		oldStudent.setName(student.getName());
		oldStudent.setPhNo(student.getPhNo());

		Student save = studentRepo.save(student);

		return save;
	}

	@Override
	public String deleteStudent(int id) {
		studentRepo.deleteById(id);
		return "Selected Sutdent records deleted";
	}
}
