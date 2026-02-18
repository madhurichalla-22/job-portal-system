package com.jobportal.system.service;

import com.jobportal.system.entity.Candidate;
import com.jobportal.system.entity.Resume;
import com.jobportal.system.repository.CandidateRepository;
import com.jobportal.system.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ResumeService implements resumeserviceinterface {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    private final String uploadDir = "uploads/";

    @Override
    public String uploadResume(Long candidateId, MultipartFile file) {

        try {
            Candidate candidate = candidateRepository.findById(candidateId).orElse(null);

            if (candidate == null) {
                return "Candidate not found";
            }

            // create uploads folder if not exist
            File folder = new File(uploadDir);
            if (!folder.exists()) {
                folder.mkdir();
            }

            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            Resume resume = new Resume(
                    file.getOriginalFilename(),
                    filePath,
                    file.getContentType(),
                    candidate
            );

            resumeRepository.save(resume);

            return "Resume uploaded successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Resume upload failed";
        }
    }
}
