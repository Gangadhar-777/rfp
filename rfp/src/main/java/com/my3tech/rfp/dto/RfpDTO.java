package com.my3tech.rfp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RfpDTO {
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

    private List<SubcontractingGoalDTO> subcontractingGoalDTO = new ArrayList<>();

    private List<ChecklistDTO> checklistDTO = new ArrayList<>();

    private List<DocumentDTO> documentDTO = new ArrayList<>();
}
