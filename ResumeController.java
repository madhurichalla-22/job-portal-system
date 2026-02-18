package com.jobportal.system.controller;

import com.jobportal.system.entity.Candidate;
import com.jobportal.system.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/candidate")
@CrossOrigin
public class ResumeController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping(value="/upload-resume/{id}", consumes = "multipart/form-data")
    public String uploadResume(@PathVariable("id") Long id,
                               @RequestParam("file") MultipartFile file) {

        try {

            String fileName = file.getOriginalFilename();

            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdir();

            File saveFile = new File(uploadDir + fileName);
            file.transferTo(saveFile);

            Candidate candidate = candidateRepository.findById(id).get();
            candidate.setResumePath(fileName);
            candidateRepository.save(candidate);

            return "Resume uploaded successfully";

        } catch (Exception e) {
            return "Error uploading resume";
        }
    }
}
