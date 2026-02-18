package com.jobportal.system.entity;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Job job;

    private String status = "APPLIED";

    public Application(){}

    public Long getId() { return id; }

    public Candidate getCandidate() { return candidate; }

    public void setCandidate(Candidate candidate) { this.candidate = candidate; }

    public Job getJob() { return job; }

    public void setJob(Job job) { this.job = job; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}