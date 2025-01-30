package com.my3tech.rfp.mapper;

import com.my3tech.rfp.dto.ChecklistDTO;
import com.my3tech.rfp.dto.ChecklistUpdateDTO;
import com.my3tech.rfp.entity.Checklist;

public class ChecklistMapper {
    public static Checklist toChecklist(ChecklistDTO checklistDTO, Checklist checklist) {
        if (checklistDTO != null && checklist != null) {
            checklist.setLetterOfIntentRequired(checklistDTO.getLetterOfIntentRequired());
            checklist.setPreBidConference(checklistDTO.getPreBidConference());
            checklist.setQuestionsDue(checklistDTO.getQuestionsDue());
            checklist.setQuestionsResponseDue(checklistDTO.getQuestionsResponseDue());
            checklist.setModeOfSubmission(checklistDTO.getModeOfSubmission());
            checklist.setInstructions(checklistDTO.getInstructions());
            checklist.setSubmissionDue(checklistDTO.getSubmissionDue());
            checklist.setStatus(checklistDTO.getStatus());
            checklist.setBidOpeningDate(checklistDTO.getBidOpeningDate());
            return checklist;
        }
        return null;
    }

    public static Checklist toUpdateChecklist(ChecklistUpdateDTO checklistDTO, Checklist checklist) {
        if (checklistDTO != null && checklist != null) {
            checklist.setId(checklistDTO.getId());
            checklist.setLetterOfIntentRequired(checklistDTO.getLetterOfIntentRequired());
            checklist.setPreBidConference(checklistDTO.getPreBidConference());
            checklist.setQuestionsDue(checklistDTO.getQuestionsDue());
            checklist.setQuestionsResponseDue(checklistDTO.getQuestionsResponseDue());
            checklist.setModeOfSubmission(checklistDTO.getModeOfSubmission());
            checklist.setInstructions(checklistDTO.getInstructions());
            checklist.setSubmissionDue(checklistDTO.getSubmissionDue());
            checklist.setStatus(checklistDTO.getStatus());
            checklist.setBidOpeningDate(checklistDTO.getBidOpeningDate());
            return checklist;
        }
        return null;
    }

    public static ChecklistDTO toChecklistDTO(Checklist checklist, ChecklistDTO checklistDTO) {
        if (checklist != null && checklistDTO != null) {
            checklistDTO.setLetterOfIntentRequired(checklist.getLetterOfIntentRequired());
            checklistDTO.setPreBidConference(checklist.getPreBidConference());
            checklistDTO.setQuestionsDue(checklist.getQuestionsDue());
            checklistDTO.setQuestionsResponseDue(checklist.getQuestionsResponseDue());
            checklistDTO.setModeOfSubmission(checklist.getModeOfSubmission());
            checklistDTO.setInstructions(checklist.getInstructions());
            checklistDTO.setSubmissionDue(checklist.getSubmissionDue());
            checklistDTO.setStatus(checklist.getStatus());
            checklistDTO.setBidOpeningDate(checklist.getBidOpeningDate());
            return checklistDTO;
        }
        return null;
    }

    public static ChecklistUpdateDTO toUpdateChecklistDTO(Checklist checklist, ChecklistUpdateDTO checklistDTO) {
        if (checklist != null && checklistDTO != null) {
            checklistDTO.setId(checklistDTO.getId());
            checklistDTO.setLetterOfIntentRequired(checklist.getLetterOfIntentRequired());
            checklistDTO.setPreBidConference(checklist.getPreBidConference());
            checklistDTO.setQuestionsDue(checklist.getQuestionsDue());
            checklistDTO.setQuestionsResponseDue(checklist.getQuestionsResponseDue());
            checklistDTO.setModeOfSubmission(checklist.getModeOfSubmission());
            checklistDTO.setInstructions(checklist.getInstructions());
            checklistDTO.setSubmissionDue(checklist.getSubmissionDue());
            checklistDTO.setStatus(checklist.getStatus());
            checklistDTO.setBidOpeningDate(checklist.getBidOpeningDate());
            return checklistDTO;
        }
        return null;
    }
}
