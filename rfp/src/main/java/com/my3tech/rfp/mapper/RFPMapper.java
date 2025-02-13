package com.my3tech.rfp.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.entity.Checklist;
import com.my3tech.rfp.entity.Documents;
import com.my3tech.rfp.entity.RFP;
import com.my3tech.rfp.entity.SubcontractingGoal;

@Mapper(componentModel = "spring", uses = { SubcontractingGoalMapper.class, ChecklistMapper.class,
        DocumentsMapper.class })
public interface RFPMapper {
    RfpDTO toDTO(RFP rfp);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "nextUser", ignore = true)
    RFP toNormal(RfpDTO dto);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "nextUser", ignore = true)
    void updateRFPFromDTO(RfpDTO dto, @MappingTarget RFP existingRfp);

    List<RfpDTO> toDTOList(List<RFP> rfps);

    List<RFP> toNormalList(List<RfpDTO> rfps);

    @AfterMapping
    default void setParentReferences(@MappingTarget RFP rfp) {
        if (rfp.getChecklists() != null) {
            for (Checklist c : rfp.getChecklists()) {
                c.setRfp(rfp);

                if (c.getBidConference() != null) {
                    c.getBidConference().setChecklist(c);
                }
            }
        }

        if (rfp.getSubcontractingGoals() != null) {
            for (SubcontractingGoal goal : rfp.getSubcontractingGoals()) {
                goal.setRfp(rfp);
            }
        }

        if (rfp.getDocuments() != null) {
            for (Documents d : rfp.getDocuments()) {
                d.setRfp(rfp);
            }
        }
    }
}
