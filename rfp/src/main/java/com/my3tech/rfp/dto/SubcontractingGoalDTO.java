package com.my3tech.rfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcontractingGoalDTO {
    private Long id;
    private String type;
    private Double goalPercentage;
    private String status;
}
