package com.bjpu.audit.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuditTrail implements Serializable {
    @Id
    @SequenceGenerator(name = "audit", sequenceName = "auditSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit")
    private Long idAuditTrail;
    private String activityName;
    private String sourceAccount;
    private String destinationAccount;
    private String resultCode;
    private String referenceNumber;
}
