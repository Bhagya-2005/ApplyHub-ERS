package com.applyhub.ers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.applyhub.ers.entity.StudentRegistration;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendRegistrationMail(StudentRegistration student) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(student.getEmail());

		message.setSubject("ApplyHub-ERS Registration Confirmation");

		message.setText("Dear " + student.getFirstName() + " " + student.getLastName() + ",\n\n"
				+ "Thank you for registering through ApplyHub-ERS.\n\n" + "Registration Details:\n"
				+ "----------------------------------\n" + "Registration ID : " + student.getRegistrationId() + "\n"
				+ "Company          : " + student.getCompanyName() + "\n" + "Exam Name        : "
				+ student.getExamName() + "\n" + "Internship Role  : " + student.getInternshipRole() + "\n"
				+ "Status           : " + student.getStatus() + "\n\n"
				+ "Your registration has been submitted successfully.\n\n" + "Regards,\n" + "ApplyHub-ERS Team");

		mailSender.send(message);
	}

}
