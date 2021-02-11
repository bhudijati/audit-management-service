package com.bjpu.audit.controller;

import com.bjpu.audit.domain.dto.AuditRequest;
import com.bjpu.audit.services.AuditManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
@Slf4j
public class AuditController {

    @Autowired
    private AuditManagementService auditManagementService;

    @PostMapping(value = "/store")
    @ResponseBody
    public void storeAudit(@RequestBody AuditRequest auditRequest) {
        try {
            auditManagementService.storeAudit(auditRequest);
        } catch (Exception ex) {
            log.error("Exception happened when Storing Audit message [{}]", ex.getMessage());
            throw ex;
        }
    }
}
