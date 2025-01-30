package com.my3tech.rfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubcontractingGoalUpdateDTO {
    private Long id;
    private String type;
    private Double goalPercentage;
    private String status;
}
