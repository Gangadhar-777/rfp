package com.my3tech.rfp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RfpUpdateDTO {
    private Long id;
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
    private String status;

    private List<SubcontractingGoalUpdateDTO> subcontractingGoalDTO = new ArrayList<>();

    private List<ChecklistUpdateDTO> checklistDTO = new ArrayList<>();

    private List<DocumentUpdateDTO> documentDTO = new ArrayList<>();
}
