package com.jobportal.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.system.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
	Employer findByEmailAndPassword(String email, String password);

}

