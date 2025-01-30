package com.my3tech.rfp.mapper;

import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.dto.RfpUpdateDTO;
import com.my3tech.rfp.entity.RFP;

public class RFPMapper {
    public static RfpDTO toRfpDTO(RFP rfp, RfpDTO rfpDTO) {
        if (rfp != null && rfpDTO != null) {

            rfpDTO.setState(rfp.getState());
            rfpDTO.setDepartment(rfp.getDepartment());
            rfpDTO.setTitle(rfp.getTitle());
            rfpDTO.setScope(rfp.getScope());
            rfpDTO.setVendorQualifications(rfp.getVendorQualifications());
            rfpDTO.setBudget(rfp.getBudget());
            rfpDTO.setIncumbentExisting(rfp.getIncumbentExisting());
            rfpDTO.setSourceLink(rfp.getSourceLink());
            rfpDTO.setUser(rfp.getUser());
            rfpDTO.setNextUser(rfp.getNextUser());
            rfpDTO.setStatus(rfp.getStatus());
            return rfpDTO;
        }
        return null;
    }

    public static RfpUpdateDTO toUpdateRfpDTO(RFP rfp, RfpUpdateDTO updateDTO) {
        if (rfp != null && updateDTO != null) {
            updateDTO.setId(rfp.getId());
            updateDTO.setState(rfp.getState());
            updateDTO.setDepartment(rfp.getDepartment());
            updateDTO.setTitle(rfp.getTitle());
            updateDTO.setScope(rfp.getScope());
            updateDTO.setVendorQualifications(rfp.getVendorQualifications());
            updateDTO.setBudget(rfp.getBudget());
            updateDTO.setIncumbentExisting(rfp.getIncumbentExisting());
            updateDTO.setSourceLink(rfp.getSourceLink());
            updateDTO.setUser(rfp.getUser());
            updateDTO.setNextUser(rfp.getNextUser());
            updateDTO.setStatus(rfp.getStatus());
            return updateDTO;
        }
        return null;
    }

    public static RFP toRFP(RfpDTO rfpDTO, RFP rfp) {
        if (rfpDTO != null && rfp != null) {
            rfp.setState(rfpDTO.getState());
            rfp.setDepartment(rfpDTO.getDepartment());
            rfp.setTitle(rfpDTO.getTitle());
            rfp.setScope(rfpDTO.getScope());
            rfp.setVendorQualifications(rfpDTO.getVendorQualifications());
            rfp.setBudget(rfpDTO.getBudget());
            rfp.setIncumbentExisting(rfpDTO.getIncumbentExisting());
            rfp.setSourceLink(rfpDTO.getSourceLink());
            rfp.setUser(rfpDTO.getUser());
            rfp.setNextUser(rfpDTO.getNextUser());
            rfp.setStatus(rfpDTO.getStatus());
            return rfp;
        }
        return null;
    }

    public static RFP toUpdateRFP(RfpUpdateDTO rfpDTO, RFP rfp) {
        if (rfpDTO != null && rfp != null) {
            rfp.setId(rfpDTO.getId());
            rfp.setState(rfpDTO.getState());
            rfp.setDepartment(rfpDTO.getDepartment());
            rfp.setTitle(rfpDTO.getTitle());
            rfp.setScope(rfpDTO.getScope());
            rfp.setVendorQualifications(rfpDTO.getVendorQualifications());
            rfp.setBudget(rfpDTO.getBudget());
            rfp.setIncumbentExisting(rfpDTO.getIncumbentExisting());
            rfp.setSourceLink(rfpDTO.getSourceLink());
            rfp.setUser(rfpDTO.getUser());
            rfp.setNextUser(rfpDTO.getNextUser());
            rfp.setStatus(rfpDTO.getStatus());
            return rfp;
        }
        return null;
    }
}
