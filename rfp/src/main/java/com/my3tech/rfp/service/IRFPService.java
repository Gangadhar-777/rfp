package com.my3tech.rfp.service;

import java.util.List;

import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.dto.RfpUpdateDTO;
import com.my3tech.rfp.entity.RFP;

public interface IRFPService {
    RFP createRFP(RfpDTO rfpDTO);
    List<RfpDTO> getRFPS();
    RFP updateRFP(RfpUpdateDTO rfpDTO);
    RfpDTO getRFP(Long rfpId);
}
