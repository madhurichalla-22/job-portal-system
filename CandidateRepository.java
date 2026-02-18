package com.jobportal.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.system.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByEmailAndPassword(String email, String password);

}