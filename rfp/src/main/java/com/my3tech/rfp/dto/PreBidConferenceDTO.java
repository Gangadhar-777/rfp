package com.my3tech.rfp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreBidConferenceDTO {
    private LocalDateTime preBidDate;
    private String status;
}
