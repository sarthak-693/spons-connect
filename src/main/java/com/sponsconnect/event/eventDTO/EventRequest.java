package com.sponsconnect.event.eventDTO;

import com.sponsconnect.event.entity.ApplicationStatus;

public class EventRequest {
    private Long seekerId;
    private String title;
    private String description;
    private Double budget;
    private String location;
    private Integer durationInMonths;
    private ApplicationStatus status;

    public EventRequest() {
    }

    public EventRequest(Long seekerId, String title, String description, Double budget, String location, Integer durationInMonths, ApplicationStatus status) {
        this.seekerId = seekerId;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.location = location;
        this.durationInMonths = durationInMonths;
        this.status = status;
    }

    public Long getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(Long seekerId) {
        this.seekerId = seekerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

}