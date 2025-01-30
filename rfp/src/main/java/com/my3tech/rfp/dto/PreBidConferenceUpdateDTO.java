package com.my3tech.rfp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreBidConferenceUpdateDTO {
    private Long id;
    private LocalDateTime preBidDate;
    private String status;
}
