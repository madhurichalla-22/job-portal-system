package com.jobportal.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jobportal.system.entity.Employer;
import com.jobportal.system.service.EmployerService;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/register")
    public Employer registerEmployer(@RequestBody Employer employer) {
        return employerService.registerEmployer(employer);
    }
    @PostMapping("/login")
    public Employer loginEmployer(@RequestParam("email") String email,
                                  @RequestParam("password") String password) {

        return employerService.login(email, password);
    }
}
