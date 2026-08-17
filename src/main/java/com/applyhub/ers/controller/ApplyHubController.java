package com.applyhub.ers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applyhub.ers.entity.StudentRegistration;
import com.applyhub.ers.request.RegistrationRequest;
import com.applyhub.ers.response.RegistrationResponse;
import com.applyhub.ers.service.StudentRegistrationService;

@RestController
public class ApplyHubController {

	@Autowired
	private StudentRegistrationService registrationService;

	// Register Student
	@PostMapping("/api/applyhub/register")
	public ResponseEntity<RegistrationResponse> registerStudent(@RequestBody RegistrationRequest request) {

		RegistrationResponse response = registrationService.registerStudent(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Get All Students
	@GetMapping("/api/applyhub/students")
	public ResponseEntity<List<StudentRegistration>> getAllStudents() {

		List<StudentRegistration> students = registrationService.getAllStudents();
		return ResponseEntity.ok(students);
	}

	// Get Student By Registration ID
	@GetMapping("/api/applyhub/studentsRegistrationId")
	public ResponseEntity<StudentRegistration> getStudentById(
			@RequestParam(value = "registrationId", required = true) Long id) {

		StudentRegistration student = registrationService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	// Update Student Registration
	@PutMapping("/api/applyhub/studentsUpdate")
	public ResponseEntity<RegistrationResponse> updateStudent(
			@RequestParam(value = "registrationId", required = true) Long id,
			@RequestBody RegistrationRequest request) {

		RegistrationResponse response = registrationService.updateStudent(id, request);
		return ResponseEntity.ok(response);
	}

	// Delete Student Registration
	@DeleteMapping("/api/applyhub/studentsDelete")
	public ResponseEntity<String> deleteStudent(@RequestParam(value = "registrationId", required = true) Long id) {

		String message = registrationService.deleteStudent(id);
		return ResponseEntity.ok(message);
	}

}
