package com.my3tech.rfp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documents extends BaseEntity {
    private String fileName;
    private String fileType;
    private String fileUrl;
    private String uploadDate;

    @ManyToOne
    @JoinColumn(name = "rfp_id")
    @JsonBackReference
    private RFP rfp;
}
