package com.jobportal.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.system.entity.Admin;
import com.jobportal.system.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin register(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin login(String email, String password){
        Admin admin = adminRepository.findByEmailAndPassword(email,password);

        if(admin == null){
            throw new RuntimeException("Invalid email or password");
        }

        return admin;
    }
}