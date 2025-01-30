package com.my3tech.rfp.mapper;

import com.my3tech.rfp.dto.DocumentDTO;
import com.my3tech.rfp.dto.DocumentUpdateDTO;
import com.my3tech.rfp.entity.Documents;

public class DocumentMapper {
    public static Documents toDocument(DocumentDTO documentDTO, Documents documents) {
        if (documentDTO != null && documents != null) {
            documents.setFileName(documentDTO.getFileName());
            documents.setFileType(documentDTO.getFileType());
            documents.setFileUrl(documentDTO.getFileUrl());
            documents.setUploadDate(documentDTO.getUploadDate());
            documents.setStatus(documentDTO.getStatus());
            return documents;
        }
        return null;
    }

    public static Documents toUpdateDocument(DocumentUpdateDTO documentDTO, Documents documents) {
        if (documentDTO != null && documents != null) {
            documents.setId(documentDTO.getId());
            documents.setFileName(documentDTO.getFileName());
            documents.setFileType(documentDTO.getFileType());
            documents.setFileUrl(documentDTO.getFileUrl());
            documents.setUploadDate(documentDTO.getUploadDate());
            documents.setStatus(documentDTO.getStatus());
            return documents;
        }
        return null;
    }

    public static DocumentDTO toDocumentDTO(Documents document, DocumentDTO documentDTO) {
        if (document != null && documentDTO != null) {
            documentDTO.setFileName(document.getFileName());
            documentDTO.setFileType(document.getFileType());
            documentDTO.setFileUrl(document.getFileUrl());
            documentDTO.setUploadDate(document.getUploadDate());
            documentDTO.setStatus(document.getStatus());
            return documentDTO;
        }
        return null;
    }

    public static DocumentUpdateDTO toUpdateDocumentDTO(Documents document, DocumentUpdateDTO documentDTO) {
        if (document != null && documentDTO != null) {
            documentDTO.setId(document.getId());
            documentDTO.setFileName(document.getFileName());
            documentDTO.setFileType(document.getFileType());
            documentDTO.setFileUrl(document.getFileUrl());
            documentDTO.setUploadDate(document.getUploadDate());
            documentDTO.setStatus(document.getStatus());
            return documentDTO;
        }
        return null;
    }
}
