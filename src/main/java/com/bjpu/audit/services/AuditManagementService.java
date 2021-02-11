package com.bjpu.audit.services;

import com.bjpu.audit.domain.dto.AuditRequest;
import com.bjpu.audit.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuditManagementService {

    @Autowired
    private AuditRepository auditRepository;

    @Transactional
    public void storeAudit(AuditRequest auditRequest) {
        auditRepository.storeDBAudit(auditRequest.getActivityName().getActivity(),
                auditRequest.getSourceAccount(), auditRequest.getDestinationAccount(),
                auditRequest.getResultCode(), auditRequest.getReferenceNumber());
    }
}
