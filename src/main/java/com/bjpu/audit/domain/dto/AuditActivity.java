package com.bjpu.audit.domain.dto;

public enum AuditActivity {
    INQUIRY("Send inquiry for Transfer to Other Bank"),
    EXECUTE("Executing for Transfer to Other Bank");

    String activity;

    AuditActivity(String activity){
        this.activity = activity;
    }
    public String getActivity() {
        return activity;
    }
}
