package com.sponsconnect.event.entity;

import com.sponsconnect.userProfile.UserProfile;
import com.sponsconnect.shared.BaseEntity;

import javax.persistence.*;

@Entity(name = "event")
@Table(name ="Event")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seeker", referencedColumnName = "id")
    private UserProfile seeker;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "budget")
    private Double budget;

    @Column(name= "location" , nullable =false)
    private String location;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApplicationStatus status;

    public Event() {

    }


    public Long getId() {
        return id;
    }

    public Event(Long id, ApplicationStatus status) {
        this.id = id;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
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


    public UserProfile getSeeker() {
        return seeker;
    }

    public void setSeeker(UserProfile seeker) {
        this.seeker = seeker;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}



