package com.jobportal.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.system.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmailAndPassword(String email, String password);
}