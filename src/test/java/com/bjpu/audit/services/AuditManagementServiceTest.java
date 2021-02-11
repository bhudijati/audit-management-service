package com.bjpu.audit.services;

import com.bjpu.audit.domain.dto.AuditActivity;
import com.bjpu.audit.domain.dto.AuditRequest;
import com.bjpu.audit.repository.AuditRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditManagementServiceTest {

    @Autowired
    private AuditManagementService auditManagementService;

    @Autowired
    private AuditRepository auditRepository;

    @Test
    public void testStoreAudit_expectSuccess_store() {
        auditManagementService.storeAudit(AuditRequest.builder()
                .activityName(AuditActivity.INQUIRY)
                .destinationAccount("1231231")
                .referenceNumber("uid12311512")
                .resultCode("00")
                .build());
        assertTrue(auditRepository.findAll().size() > 0);
    }

    @After
    public void release() {
        auditRepository.deleteAllInBatch();
    }


}