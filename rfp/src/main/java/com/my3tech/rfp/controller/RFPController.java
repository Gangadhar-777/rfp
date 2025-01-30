package com.my3tech.rfp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.dto.RfpUpdateDTO;
import com.my3tech.rfp.entity.RFP;
import com.my3tech.rfp.service.IRFPService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rfp")
@RequiredArgsConstructor
public class RFPController {
    private final IRFPService rfpService;

    @GetMapping
    public ResponseEntity<List<RfpDTO>> getRFPS() {
        return ResponseEntity.ok(rfpService.getRFPS());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RfpDTO> getRFP(@PathVariable Long id) {
        return ResponseEntity.ok(rfpService.getRFP(id));
    }

    @PostMapping
    public ResponseEntity<RFP> createRFP(@RequestBody RfpDTO dto) {
        return ResponseEntity.ok(rfpService.createRFP(dto));
    }

    @PutMapping
    public ResponseEntity<RFP> updateRFP(@RequestBody RfpUpdateDTO rfpDTO) {
        return ResponseEntity.ok(rfpService.updateRFP(rfpDTO));
    }
}
