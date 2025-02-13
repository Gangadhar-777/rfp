package com.my3tech.rfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentsDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private String uploadDate;
    private String status;
}
