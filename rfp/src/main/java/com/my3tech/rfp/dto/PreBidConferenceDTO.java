package com.my3tech.rfp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrebidConferenceDTO {
    private Long id;
    private LocalDateTime preBidDate;
    private String status;
}
