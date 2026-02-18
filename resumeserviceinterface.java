package com.jobportal.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface resumeserviceinterface {

    String uploadResume(Long candidateId, MultipartFile file);
}
