package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService serv;
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		return new ResponseEntity<>(serv.getStudent(id),HttpStatus.FOUND);
	}
	@GetMapping("student")
	public ResponseEntity<List<Student>> getAllStudent(){
		return new ResponseEntity<>(serv.getAllStudent(),HttpStatus.FOUND);
	}
	@PostMapping("student")
	public ResponseEntity<Student> addCustomer(@RequestBody Student obj){
		return new ResponseEntity<>(serv.addStudent(obj),HttpStatus.ACCEPTED);
	}
	@PatchMapping("student/{id}")
	public ResponseEntity<String> updateMajor(@PathVariable int id, @RequestBody Student major){
		return new ResponseEntity<>(serv.updateMajor(id, major),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		return new ResponseEntity<>(serv.deleteStudent(id),HttpStatus.ACCEPTED);
	}
}
