package com.my3tech.rfp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.entity.RFP;
import com.my3tech.rfp.exceptions.NotFoundException;
import com.my3tech.rfp.mapper.RFPMapper;
import com.my3tech.rfp.repository.RFPRepository;
import com.my3tech.rfp.service.IRFPService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RFPServiceImpl implements IRFPService {
        private final RFPRepository rfpRepository;
        private final RFPMapper rfpMapper;

        @Override
        public RFP updateRFP(RfpDTO rfpDTO) {
                // Note: Pending stuff for update logic (Only 1 issue solved)
                RFP existingRFP = rfpRepository.findById(rfpDTO.getId())
                        .orElseThrow(() -> new RuntimeException("RFP Not found!"));
                rfpMapper.updateRFPFromDTO(rfpDTO, existingRFP);
                return rfpRepository.save(existingRFP);
        }

        @Override
        public RFP createRFP(RfpDTO rfpDTO) {
                RFP rfp = rfpMapper.toNormal(rfpDTO);
                return rfpRepository.save(rfp);
        }

        @Override
        public RfpDTO getRFP(Long id) {
                RFP rfp = rfpRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Invalid rfp for id - " + id));
                return rfpMapper.toDTO(rfp);
        }

        @Override
        public List<RfpDTO> getRFPS() {
                return rfpMapper.toDTOList(rfpRepository.findAll());
        }

}

