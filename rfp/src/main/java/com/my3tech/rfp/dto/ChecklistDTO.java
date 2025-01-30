package com.my3tech.rfp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChecklistDTO {
    private String letterOfIntentRequired;
    private String preBidConference;
    private LocalDateTime questionsDue;
    private LocalDateTime questionsResponseDue;
    private String modeOfSubmission;
    private String instructions;
    private LocalDateTime submissionDue;
    private LocalDateTime bidOpeningDate;
    private String status;
    private PreBidConferenceDTO preBidConferenceDTO;
}
