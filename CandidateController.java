package com.jobportal.system.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.system.entity.Candidate;
import com.jobportal.system.repository.CandidateRepository;
import com.jobportal.system.service.CandidateService;
import java.util.List;
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateRepository candidateRepository;

    // REGISTER
    @PostMapping("/register")
    public Candidate register(@RequestBody Candidate candidate){
        return candidateService.register(candidate);
    }

    // LOGIN
    @PostMapping("/login")
    public Candidate login(@RequestParam("email") String email,
                           @RequestParam("password") String password){
        return candidateService.login(email,password);
    }

    // UPLOAD RESUME
    @PostMapping("/uploadResume/{candidateId}")
    public String uploadResume(@RequestParam("file") MultipartFile file,
                               @PathVariable Long candidateId) {

        try {
            String fileName = file.getOriginalFilename();
            String path = "C:/resumes/" + fileName;

            file.transferTo(new File(path));

            Candidate candidate = candidateRepository.findById(candidateId).get();
            candidate.setResumePath(fileName);

            candidateRepository.save(candidate);

            return "Resume uploaded";

        } catch (Exception e) {
            return "Error uploading resume";
        }
    }
    @GetMapping("/all")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }
}