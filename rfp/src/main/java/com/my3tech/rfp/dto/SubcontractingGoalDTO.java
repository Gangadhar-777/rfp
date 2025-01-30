package com.my3tech.rfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcontractingGoalDTO {
    private String type;
    private Double goalPercentage;
    private String status;
}
