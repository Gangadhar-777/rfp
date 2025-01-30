package com.my3tech.rfp.mapper;

import com.my3tech.rfp.dto.SubcontractingGoalDTO;
import com.my3tech.rfp.dto.SubcontractingGoalUpdateDTO;
import com.my3tech.rfp.entity.SubcontractingGoal;

public class SubContractingGoalsMapper {
    public static SubcontractingGoal toSubcontractingGoal(SubcontractingGoalDTO dto, SubcontractingGoal goal) {
        if (goal != null && dto.getStatus() != null) {
            goal.setStatus(dto.getStatus());
            goal.setType(dto.getType());
            goal.setGoalPercentage(dto.getGoalPercentage());
            return goal;
        }
        return null;
    }

    public static SubcontractingGoal toUpdateSubcontractingGoal(SubcontractingGoalUpdateDTO dto,
            SubcontractingGoal goal) {
        if (goal != null && dto.getStatus() != null) {
            goal.setId(dto.getId());
            goal.setStatus(dto.getStatus());
            goal.setType(dto.getType());
            goal.setGoalPercentage(dto.getGoalPercentage());
            return goal;
        }
        return null;
    }

    public static SubcontractingGoalDTO toSubcontractingGoalDTO(SubcontractingGoal goal, SubcontractingGoalDTO dto) {
        if (dto != null && goal != null) {
            dto.setType(goal.getType());
            dto.setGoalPercentage(goal.getGoalPercentage());
            dto.setStatus(goal.getStatus());
            return dto;
        }
        return null;
    }

    public static SubcontractingGoalUpdateDTO toUpdateSubcontractingGoalDTO(SubcontractingGoal goal,
            SubcontractingGoalUpdateDTO dto) {
        if (dto != null && goal != null) {
            dto.setId(goal.getId());
            dto.setType(goal.getType());
            dto.setGoalPercentage(goal.getGoalPercentage());
            dto.setStatus(goal.getStatus());
            return dto;
        }
        return null;
    }
}
