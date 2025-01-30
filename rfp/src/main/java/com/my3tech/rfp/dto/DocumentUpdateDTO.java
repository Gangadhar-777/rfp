package com.my3tech.rfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentUpdateDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private String uploadDate;
    private String status;
}
