package com.sponsconnect.event.entity;

import com.sponsconnect.shared.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "event")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sponsor_id", referencedColumnName = "id")
//    private UserProfile sponsor;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "sponsorship_type", nullable = false)
    private String sponsorshipType;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @Column(name = "duration_in_months", nullable = false)
    private Integer durationInMonths;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SponsorshipStatus status;



    public Long getId() {
        return id;
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

    public String getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(String sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
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

    public SponsorshipStatus getStatus() {
        return status;
    }

    public void setStatus(SponsorshipStatus status) {
        this.status = status;
    }
}



enum SponsorshipStatus {
    PENDING,
    APPROVED,
    REJECTED,
    COMPLETED
}
