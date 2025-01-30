package com.my3tech.rfp.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Checklist extends BaseEntity {
    private String letterOfIntentRequired;
    private String preBidConference;
    private LocalDateTime questionsDue;
    private LocalDateTime questionsResponseDue;
    private String modeOfSubmission;
    private String instructions;
    private LocalDateTime submissionDue;
    private LocalDateTime bidOpeningDate;

    @OneToOne(mappedBy = "checklist", cascade = CascadeType.ALL)
    @JsonManagedReference
    private PreBidConference bidConference;

    @ManyToOne
    @JoinColumn(name = "rfp_id")
    @JsonBackReference
    private RFP rfp;
}
