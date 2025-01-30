package com.my3tech.rfp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class SubcontractingGoal extends BaseEntity {
    private String type;
    private Double goalPercentage;

    @ManyToOne
    @JoinColumn(name = "rfp_id")
    @JsonBackReference
    private RFP rfp;
}
