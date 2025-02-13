package com.my3tech.rfp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my3tech.rfp.dto.SubcontractingGoalDTO;
import com.my3tech.rfp.entity.SubcontractingGoal;

@Mapper(componentModel = "spring")
public interface SubcontractingGoalMapper {
    SubcontractingGoalDTO toDTO(SubcontractingGoal goal);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "rfp", ignore = true)
    SubcontractingGoal toNormal(SubcontractingGoalDTO dto);

    List<SubcontractingGoal> toNormalList(List<SubcontractingGoalDTO> dtos);
    List<SubcontractingGoalDTO> toDTOList(List<SubcontractingGoal> goals);

}
