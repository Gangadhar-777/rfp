package com.my3tech.rfp.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.my3tech.rfp.dto.ChecklistDTO;
import com.my3tech.rfp.entity.Checklist;

@Mapper(componentModel = "spring", uses = {PrebidConferenceMapper.class})
public interface ChecklistMapper {
    @Mapping(source = "bidConference", target = "conference")
    ChecklistDTO toDTO(Checklist checklist);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "rfp", ignore = true)
    @Mapping(target = "bidConference", source = "conference")
    Checklist toNormal(ChecklistDTO dto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "bidConference", source = "conference")
    @Mapping(target = "rfp", ignore = true)
    void updateChecklistFromDTO(ChecklistDTO dto, @MappingTarget Checklist checklist);

    List<ChecklistDTO> toDTOList(List<Checklist> checklists);
    List<Checklist> toNormalList(List<ChecklistDTO> dtos);


    @AfterMapping
    default void maintainRelationship(@MappingTarget Checklist checklist) {
        if(checklist.getBidConference() != null) {
            checklist.getBidConference().setChecklist(checklist);
        }
    }

}
