package com.my3tech.rfp.mapper;

import com.my3tech.rfp.dto.PreBidConferenceDTO;
import com.my3tech.rfp.dto.PreBidConferenceUpdateDTO;
import com.my3tech.rfp.entity.PreBidConference;

public class PreBidConferenceMapper {
    public static PreBidConferenceDTO toPreBidConferenceDTO(PreBidConference conf, PreBidConferenceDTO dto) {
        if (conf != null && dto != null) {
            dto.setPreBidDate(conf.getPreBidDate());
            dto.setStatus(conf.getStatus());
            return dto;
        }
        return null;
    }

    public static PreBidConferenceUpdateDTO toUpdatePreBidConferenceDTO(PreBidConference conf,
            PreBidConferenceUpdateDTO dto) {
        if (conf != null && dto != null) {
            dto.setId(conf.getId());
            dto.setPreBidDate(conf.getPreBidDate());
            dto.setStatus(conf.getStatus());
            return dto;
        }
        return null;
    }

    public static PreBidConference toPreBidConference(PreBidConferenceDTO dto, PreBidConference conf) {
        if (conf != null && dto != null) {
            conf.setStatus(dto.getStatus());
            conf.setPreBidDate(dto.getPreBidDate());
            return conf;
        }
        return null;
    }

    public static PreBidConference toUpdatePreBidConference(PreBidConferenceUpdateDTO dto, PreBidConference conf) {
        if (conf != null && dto != null) {
            conf.setId(dto.getId());
            conf.setStatus(dto.getStatus());
            conf.setPreBidDate(dto.getPreBidDate());
            return conf;
        }
        return null;
    }
}
