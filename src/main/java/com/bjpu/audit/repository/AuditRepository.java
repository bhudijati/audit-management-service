package com.bjpu.audit.repository;

import com.bjpu.audit.domain.entity.AuditTrail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditTrail, Long> {

    @Modifying
    @Query(value = "INSERT INTO AUDIT_TRAIL" +
            "(ID_AUDIT_TRAIL,ACTIVITY_NAME " +
            ",SOURCE_ACCOUNT, DESTINATION_ACCOUNT " +
            ",RESULT_CODE, REFERENCE_NUMBER) VALUES ((SELECT AUDIT_SEQ.NEXTVAL), ?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void storeDBAudit(String activityName, String sourceAccount, String destinationAccount,
                      String resultCode, String referenceNumber);
}
