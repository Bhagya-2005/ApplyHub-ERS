package com.applyhub.ers.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.applyhub.ers.entity.StudentRegistration;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {

	Optional<StudentRegistration> findByEmail(String email);

}