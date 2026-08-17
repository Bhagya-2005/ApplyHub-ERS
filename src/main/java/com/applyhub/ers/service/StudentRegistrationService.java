package com.applyhub.ers.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applyhub.ers.entity.StudentRegistration;
import com.applyhub.ers.repo.StudentRegistrationRepository;
import com.applyhub.ers.request.RegistrationRequest;
import com.applyhub.ers.response.RegistrationResponse;

@Service
public class StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository repository;

	@Autowired
	private EmailService emailService;

	// Register Student
	public RegistrationResponse registerStudent(RegistrationRequest request) {

		if (repository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Student already registered with Email : " + request.getEmail());
		}

		StudentRegistration student = new StudentRegistration();

		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());
		student.setPhone(request.getPhone());
		student.setCollegeName(request.getCollegeName());
		student.setBranch(request.getBranch());
		student.setGraduationYear(request.getGraduationYear());
		student.setCompanyName(request.getCompanyName());
		student.setExamName(request.getExamName());
		student.setInternshipRole(request.getInternshipRole());
		student.setRegistrationDate(LocalDateTime.now());
		student.setStatus("REGISTERED");
		student.setCreateTs(LocalDateTime.now());
		student.setCreateUser("SYSTEM");

		StudentRegistration savedStudent = repository.save(student);
		emailService.sendRegistrationMail(savedStudent);

		RegistrationResponse response = new RegistrationResponse();
		response.setRegistrationId(savedStudent.getRegistrationId());
		response.setMessage("Registration Successful");
		response.setEmailSent(true);

		return response;
	}

	// Get All Students
	public List<StudentRegistration> getAllStudents() {
		return repository.findAll();
	}
	
	// Get Student By ID
    public StudentRegistration getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student Not Found with ID : " + id));
    }
    
 // Update Student
    public RegistrationResponse updateStudent(Long id,
                                              RegistrationRequest request) {

        StudentRegistration student = getStudentById(id);

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCollegeName(request.getCollegeName());
        student.setBranch(request.getBranch());
        student.setGraduationYear(request.getGraduationYear());
        student.setCompanyName(request.getCompanyName());
        student.setExamName(request.getExamName());
        student.setInternshipRole(request.getInternshipRole());
        student.setUpdateTs(LocalDateTime.now());
        student.setUpdateUser("SYSTEM");

        repository.save(student);

        RegistrationResponse response = new RegistrationResponse();
        response.setRegistrationId(student.getRegistrationId());
        response.setMessage("Student Registration Updated Successfully");
        response.setEmailSent(false);

        return response;
    }

    // Delete Student
    public String deleteStudent(Long id) {

        StudentRegistration student = getStudentById(id);

        repository.delete(student);

        return "Student Registration Deleted Successfully";
    }

}

