package com.jobportal.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.system.entity.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByCandidateId(Long candidateId);

    boolean existsByCandidateIdAndJobId(Long candidateId, Long jobId);
}