package com.my3tech.rfp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my3tech.rfp.dto.DocumentsDTO;
import com.my3tech.rfp.entity.Documents;

@Mapper(componentModel = "spring")
public interface DocumentsMapper {
    DocumentsDTO toDTO(Documents document);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "rfp", ignore = true)
    Documents toNormal(DocumentsDTO dto);

    List<DocumentsDTO> toDTOList(List<Documents> document);
    List<Documents> toNormalList(List<DocumentsDTO> dtos);
}
