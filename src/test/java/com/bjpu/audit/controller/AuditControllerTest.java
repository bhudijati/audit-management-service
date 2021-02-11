package com.bjpu.audit.controller;

import com.bjpu.audit.domain.dto.AuditActivity;
import com.bjpu.audit.domain.dto.AuditRequest;
import com.bjpu.audit.exceptions.GenericException;
import com.bjpu.audit.services.AuditManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuditManagementService auditManagementService;

    @SneakyThrows
    @Test
    public void testStoreAudit_expectSuccess_store() {
        mockMvc.perform(post("/v1/store")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(AuditRequest.builder()
                        .activityName(AuditActivity.INQUIRY)
                        .destinationAccount("1231231")
                        .referenceNumber("uid12311512")
                        .resultCode("00")
                        .build())))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    @Test(expected = Exception.class)
    public void testStoreAudit_expectFailed_store() {
        doThrow(GenericException.class).when(auditManagementService).storeAudit(any());
        mockMvc.perform(post("/v1/store")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(AuditRequest.builder()
                        .activityName(AuditActivity.INQUIRY)
                        .destinationAccount("1231231")
                        .referenceNumber("uid12311512")
                        .resultCode("00")
                        .build())))
                .andExpect(status().isBadRequest());
    }
}