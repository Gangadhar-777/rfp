package com.my3tech.rfp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class RFP extends BaseEntity {
    private String state;
    private String department;
    private String title;
    private String scope;
    private String vendorQualifications;
    private Double budget;
    private String incumbentExisting;
    private String sourceLink;
    private Integer user;
    private Integer nextUser;

    @OneToMany(mappedBy = "rfp", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SubcontractingGoal> subcontractingGoals = new ArrayList<>();

    @OneToMany(mappedBy = "rfp", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Checklist> checklists = new ArrayList<>();

    @OneToMany(mappedBy = "rfp", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Documents> documents = new ArrayList<>();  
}
