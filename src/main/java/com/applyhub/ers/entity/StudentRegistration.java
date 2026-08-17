package com.applyhub.ers.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRegistration {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "registration_id")
	    private Long registrationId;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "college_name")
	    private String collegeName;

	    @Column(name = "branch")
	    private String branch;

	    @Column(name = "graduation_year")
	    private Integer graduationYear;

	    @Column(name = "company_name")
	    private String companyName;

	    @Column(name = "exam_name")
	    private String examName;

	    @Column(name = "internship_role")
	    private String internshipRole;

	    @Column(name = "registration_date")
	    private LocalDateTime registrationDate;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "create_ts")
	    private LocalDateTime createTs;

	    @Column(name = "create_user")
	    private String createUser;

	    @Column(name = "update_ts")
	    private LocalDateTime updateTs;

	    @Column(name = "update_user")
	    private String updateUser;

		public Long getRegistrationId() {
			return registrationId;
		}

		public void setRegistrationId(Long registrationId) {
			this.registrationId = registrationId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCollegeName() {
			return collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public Integer getGraduationYear() {
			return graduationYear;
		}

		public void setGraduationYear(Integer graduationYear) {
			this.graduationYear = graduationYear;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getExamName() {
			return examName;
		}

		public void setExamName(String examName) {
			this.examName = examName;
		}

		public String getInternshipRole() {
			return internshipRole;
		}

		public void setInternshipRole(String internshipRole) {
			this.internshipRole = internshipRole;
		}

		public LocalDateTime getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public LocalDateTime getCreateTs() {
			return createTs;
		}

		public void setCreateTs(LocalDateTime createTs) {
			this.createTs = createTs;
		}

		public String getCreateUser() {
			return createUser;
		}

		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}

		public LocalDateTime getUpdateTs() {
			return updateTs;
		}

		public void setUpdateTs(LocalDateTime updateTs) {
			this.updateTs = updateTs;
		}

		public String getUpdateUser() {
			return updateUser;
		}

		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}
	    
	    

	}

