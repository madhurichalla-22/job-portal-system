package com.jobportal.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.system.entity.Employer;
import com.jobportal.system.repository.EmployerRepository;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer registerEmployer(Employer employer) {
        employer.setVerified(false);
        return employerRepository.save(employer);
    }
    public Employer login(String email, String password){

        Employer emp = employerRepository.findByEmailAndPassword(email, password);

        if(emp == null){
            throw new RuntimeException("Invalid email or password");
        }

        if(!emp.isVerified()){
            throw new RuntimeException("Admin not verified your account yet");
        }

        return emp;
    }

    
}
