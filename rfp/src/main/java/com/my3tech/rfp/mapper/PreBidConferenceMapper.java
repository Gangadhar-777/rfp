package com.my3tech.rfp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my3tech.rfp.dto.PrebidConferenceDTO;
import com.my3tech.rfp.entity.PreBidConference;

@Mapper(componentModel = "spring")
public interface PrebidConferenceMapper {
    PrebidConferenceDTO toDTO(PreBidConference conference);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "checklist", ignore = true)
    PreBidConference toNormal(PrebidConferenceDTO dto);


    List<PrebidConferenceDTO> toDTOList(List<PreBidConference> conferences);
    List<PreBidConference> toNormal(List<PrebidConferenceDTO> dtos);
}
