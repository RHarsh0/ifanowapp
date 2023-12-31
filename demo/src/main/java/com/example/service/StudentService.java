package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	

	public Student addStudent(Student obj) {
		return repo.save(obj);
	}
	
	public Student getStudent(int id) {
		Optional<Student> opt = repo.findById(id);
		if(opt.get()!=null) {
			return opt.get();
		}else {
			throw new RuntimeException("unable to find the student with given id");
		}
	}
	
	public String updateMajor(int id, Student major) {
		Optional<Student> opt = repo.findById(id);
		if(opt.get()!=null) {
			Student obj  = opt.get();
			major.setId(id);
			repo.save(major);
			return "major is updated";
		}else {
			throw new RuntimeException("unable to find the student with given id");
		}
	}
	
	public String deleteStudent(int id) {
		Optional<Student> opt = repo.findById(id);
		if(opt.get()!=null) {
			repo.deleteById(id);
			return "student is deleted";
		}else {
			throw new RuntimeException("unable to find the student with given id");
		}
		 
	}

	public List<Student> getAllStudent() {
		return repo.findAll();
	}
}
