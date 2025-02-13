package com.my3tech.rfp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RfpDTO {
    private Long id;
    private String state;
    private String department;
    private String title;
    private String scope;
    private String vendorQualifications;
    private Double budget;
    private String incumbentExisting;
    private String sourceLink;
    private String status;

    private List<SubcontractingGoalDTO> subcontractingGoals;
    private List<ChecklistDTO> checklists;
    private List<DocumentsDTO> documents;
}
