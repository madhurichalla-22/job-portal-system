package com.jobportal.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.system.entity.Admin;
import com.jobportal.system.entity.Employer;
import com.jobportal.system.service.AdminService;
import com.jobportal.system.repository.EmployerRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployerRepository employerRepository;

    // ADMIN REGISTER
    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin){
        return adminService.register(admin);
    }

    // ADMIN LOGIN
    @PostMapping("/login")
    public Admin login(@RequestParam("email") String email,
                       @RequestParam("password") String password){
        return adminService.login(email,password);
    }

    // VERIFY EMPLOYER
    @PutMapping("/verify/{id}")
    public Employer verifyEmployer(@PathVariable("id") Long id){
        Employer emp = employerRepository.findById(id).get();
        emp.setVerified(true);
        return employerRepository.save(emp);
    }
}