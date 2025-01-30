package com.my3tech.rfp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.my3tech.rfp.dto.ChecklistDTO;
import com.my3tech.rfp.dto.DocumentDTO;
import com.my3tech.rfp.dto.PreBidConferenceDTO;
import com.my3tech.rfp.dto.RfpDTO;
import com.my3tech.rfp.dto.RfpUpdateDTO;
import com.my3tech.rfp.dto.SubcontractingGoalDTO;
import com.my3tech.rfp.entity.Checklist;
import com.my3tech.rfp.entity.Documents;
import com.my3tech.rfp.entity.PreBidConference;
import com.my3tech.rfp.entity.RFP;
import com.my3tech.rfp.entity.SubcontractingGoal;
import com.my3tech.rfp.exceptions.NotFoundException;
import com.my3tech.rfp.mapper.ChecklistMapper;
import com.my3tech.rfp.mapper.DocumentMapper;
import com.my3tech.rfp.mapper.PreBidConferenceMapper;
import com.my3tech.rfp.mapper.RFPMapper;
import com.my3tech.rfp.mapper.SubContractingGoalsMapper;
import com.my3tech.rfp.repository.RFPRepository;
import com.my3tech.rfp.service.IRFPService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RFPServiceImpl implements IRFPService {
        private final RFPRepository rfpRepository;

        @Override
        public RFP updateRFP(RfpUpdateDTO rfpDTO) {
                RFP existingRFP = rfpRepository.findById(rfpDTO.getId())
                                .orElseThrow(() -> new NotFoundException(
                                                "Rfp For Given Id - " + rfpDTO.getId() + " Not Found"));
                RFP rfp = RFPMapper.toUpdateRFP(rfpDTO, existingRFP);

                if (rfpDTO.getSubcontractingGoalDTO() != null) {
                        Map<Long, SubcontractingGoal> existingGoalsMap = existingRFP.getSubcontractingGoals()
                                        .stream().collect(Collectors.toMap(SubcontractingGoal::getId, goal -> goal));

                        List<SubcontractingGoal> updatedGoals = rfpDTO.getSubcontractingGoalDTO().stream()
                                        .map(goalDTO -> {
                                                SubcontractingGoal goal = existingGoalsMap.getOrDefault(goalDTO.getId(),
                                                                new SubcontractingGoal());
                                                goal = SubContractingGoalsMapper.toUpdateSubcontractingGoal(goalDTO,
                                                                goal);
                                                goal.setRfp(rfp);
                                                return goal;
                                        }).collect(Collectors.toList());

                        rfp.setSubcontractingGoals(updatedGoals);
                }

                if (rfpDTO.getChecklistDTO() != null) {
                        Map<Long, Checklist> existingCheckMap = existingRFP.getChecklists()
                                        .stream().collect(Collectors.toMap(Checklist::getId, checklist -> checklist));

                        List<Checklist> updatedChecklists = rfpDTO.getChecklistDTO().stream()
                                        .map(cheque -> {
                                                Checklist c = existingCheckMap.getOrDefault(cheque.getId(),
                                                                new Checklist());
                                                c = ChecklistMapper.toUpdateChecklist(cheque, c);

                                                PreBidConference pc = cheque.getPreBidConferenceDTO() != null
                                                                ? PreBidConferenceMapper.toUpdatePreBidConference(
                                                                                cheque.getPreBidConferenceDTO(),
                                                                                c.getBidConference() != null
                                                                                                ? c.getBidConference()
                                                                                                : new PreBidConference())
                                                                : null;

                                                if (pc != null) {
                                                        pc.setChecklist(c);
                                                        c.setBidConference(pc);
                                                }

                                                c.setRfp(rfp);
                                                return c;
                                        }).collect(Collectors.toList());

                        rfp.setChecklists(updatedChecklists);
                }

                if (rfpDTO.getDocumentDTO() != null) {
                        Map<Long, Documents> existingDocsMap = existingRFP.getDocuments()
                                        .stream().collect(Collectors.toMap(Documents::getId, doc -> doc));

                        List<Documents> updatedDocuments = rfpDTO.getDocumentDTO().stream()
                                        .map(doc -> {
                                                Documents document = existingDocsMap.getOrDefault(doc.getId(),
                                                                new Documents());
                                                document = DocumentMapper.toUpdateDocument(doc, document);
                                                document.setRfp(rfp);
                                                return document;
                                        }).collect(Collectors.toList());

                        rfp.setDocuments(updatedDocuments);
                }

                return rfpRepository.saveAndFlush(rfp);
        }

        // @Override
        // public RFP updateRFP(RfpUpdateDTO rfpDTO) {
        // RFP existingRFP = rfpRepository.findById(rfpDTO.getId())
        // .orElseThrow(() -> new RFPNotFoundException("Rfp For Given Id - " +
        // rfpDTO.getId() + " Not Found"));

        // RFP rfp = RFPMapper.toUpdateRFP(rfpDTO, existingRFP);

        // if (rfpDTO.getSubcontractingGoalDTO() != null &&
        // !rfpDTO.getSubcontractingGoalDTO().isEmpty()) {
        // List<SubcontractingGoal> goals = rfpDTO.getSubcontractingGoalDTO().stream()
        // .map(goalDTO -> {
        // SubcontractingGoal goal =
        // SubContractingGoalsMapper.toUpdateSubcontractingGoal(goalDTO,
        // new SubcontractingGoal());
        // goal.setRfp(rfp);
        // return goal;
        // })
        // .collect(Collectors.toCollection(ArrayList::new));
        // rfp.setSubcontractingGoals(goals);
        // }

        // if (rfpDTO.getChecklistDTO() != null && !rfpDTO.getChecklistDTO().isEmpty())
        // {
        // List<Checklist> checks = rfpDTO.getChecklistDTO().stream().map(cheque -> {
        // Checklist c = ChecklistMapper.toUpdateChecklist(cheque, new Checklist());
        // PreBidConference pc = PreBidConferenceMapper.toUpdatePreBidConference(
        // cheque.getPreBidConferenceDTO(),
        // new PreBidConference());
        // if (pc != null) {
        // pc.setChecklist(c);
        // c.setBidConference(pc);
        // }
        // c.setRfp(rfp);
        // return c;
        // }).collect(Collectors.toCollection(ArrayList::new));
        // rfp.setChecklists(checks);
        // }

        // if (rfpDTO.getDocumentDTO() != null && !rfpDTO.getDocumentDTO().isEmpty()) {
        // List<Documents> documents = rfpDTO.getDocumentDTO().stream()
        // .map(doc -> {
        // Documents document = DocumentMapper.toUpdateDocument(doc, new Documents());
        // document.setRfp(rfp);
        // return document;
        // }).collect(Collectors.toCollection(ArrayList::new));

        // rfp.setDocuments(documents);
        // }

        // rfpRepository.saveAndFlush(rfp);

        // return rfpRepository.findById(existingRFP.getId()).orElse(null);
        // }

        @Transactional
        @Override
        public RFP createRFP(RfpDTO rfpDTO) {
                RFP rfp = RFPMapper.toRFP(rfpDTO, new RFP());

                if (rfpDTO.getSubcontractingGoalDTO() != null && !rfpDTO.getSubcontractingGoalDTO().isEmpty()) {
                        List<SubcontractingGoal> goals = new ArrayList<>(rfpDTO.getSubcontractingGoalDTO().stream()
                                        .map(goalDTO -> {
                                                SubcontractingGoal goal = SubContractingGoalsMapper
                                                                .toSubcontractingGoal(goalDTO,
                                                                                new SubcontractingGoal());
                                                goal.setRfp(rfp);
                                                return goal;
                                        })
                                        .toList());
                        rfp.setSubcontractingGoals(goals);
                }

                if (rfpDTO.getChecklistDTO() != null && !rfpDTO.getChecklistDTO().isEmpty()) {
                        List<Checklist> cheques = new ArrayList<>(rfpDTO.getChecklistDTO().stream()
                                        .map(checkList -> {
                                                Checklist cl = ChecklistMapper.toChecklist(checkList, new Checklist());
                                                PreBidConference pc = PreBidConferenceMapper
                                                                .toPreBidConference(checkList.getPreBidConferenceDTO(),
                                                                                new PreBidConference());
                                                if (pc != null) {
                                                        pc.setChecklist(cl);
                                                        cl.setBidConference(pc);
                                                }
                                                cl.setRfp(rfp);
                                                return cl;
                                        })
                                        .toList());
                        rfp.setChecklists(cheques);
                }

                if (rfpDTO.getDocumentDTO() != null && !rfpDTO.getDocumentDTO().isEmpty()) {
                        List<Documents> documents = new ArrayList<>(rfpDTO.getDocumentDTO().stream()
                                        .map(doc -> {
                                                Documents document = DocumentMapper.toDocument(doc, new Documents());
                                                document.setRfp(rfp);
                                                return document;
                                        })
                                        .toList());
                        rfp.setDocuments(documents);
                }

                return rfpRepository.save(rfp);
        }

        @Override
        public RfpDTO getRFP(Long id) {
                RFP rfp = rfpRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Invalid rfp for id - " + id));

                List<SubcontractingGoalDTO> goals = rfp.getSubcontractingGoals()
                                .stream()
                                .map(goal -> SubContractingGoalsMapper.toSubcontractingGoalDTO(goal,
                                                new SubcontractingGoalDTO()))
                                .toList();

                List<ChecklistDTO> cheques = rfp.getChecklists()
                                .stream()
                                .map(cheque -> {
                                        PreBidConferenceDTO confDTO = PreBidConferenceMapper
                                                        .toPreBidConferenceDTO(cheque.getBidConference(),
                                                                        new PreBidConferenceDTO());
                                        ChecklistDTO dto = ChecklistMapper.toChecklistDTO(cheque, new ChecklistDTO());
                                        dto.setPreBidConferenceDTO(confDTO);
                                        return dto;
                                })
                                .toList();

                List<DocumentDTO> docs = rfp.getDocuments().stream()
                                .map(doc -> DocumentMapper.toDocumentDTO(doc, new DocumentDTO()))
                                .toList();

                RfpDTO rfpDTO = RFPMapper.toRfpDTO(rfp, new RfpDTO());
                rfpDTO.setDocumentDTO(docs);
                rfpDTO.setChecklistDTO(cheques);
                rfpDTO.setSubcontractingGoalDTO(goals);

                return rfpDTO;
        }

        @Override
        public List<RfpDTO> getRFPS() {
                List<RfpDTO> convertedRfps = rfpRepository.findAll().stream()
                                .map(rfp -> {
                                        List<SubcontractingGoalDTO> goals = rfp
                                                        .getSubcontractingGoals().stream()
                                                        .map(goal -> SubContractingGoalsMapper.toSubcontractingGoalDTO(
                                                                        goal,
                                                                        new SubcontractingGoalDTO()))
                                                        .toList();

                                        List<ChecklistDTO> cheques = rfp.getChecklists()
                                                        .stream()
                                                        .map(cheque -> {
                                                                PreBidConferenceDTO confDTO = PreBidConferenceMapper
                                                                                .toPreBidConferenceDTO(cheque
                                                                                                .getBidConference(),
                                                                                                new PreBidConferenceDTO());
                                                                ChecklistDTO dto = ChecklistMapper.toChecklistDTO(
                                                                                cheque, new ChecklistDTO());
                                                                dto.setPreBidConferenceDTO(confDTO);
                                                                return dto;
                                                        })
                                                        .toList();

                                        List<DocumentDTO> docs = rfp.getDocuments().stream()
                                                        .map(doc -> DocumentMapper.toDocumentDTO(doc,
                                                                        new DocumentDTO()))
                                                        .toList();

                                        RfpDTO rfpDTO = RFPMapper.toRfpDTO(rfp, new RfpDTO());
                                        rfpDTO.setDocumentDTO(docs);
                                        rfpDTO.setChecklistDTO(cheques);
                                        rfpDTO.setSubcontractingGoalDTO(goals);

                                        return rfpDTO;
                                }).toList();

                return convertedRfps;
        }

}
