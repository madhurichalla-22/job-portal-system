package com.jobportal.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.system.entity.Job;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByEmployerId(Long employerId);
}
