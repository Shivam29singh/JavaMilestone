package com.dc.truckdcslotsystem.model;

import javax.persistence.Column;

public class DctimeSlotRequest {


    private String dcTimeSlot;


    public DctimeSlotRequest() {
    }

    public DctimeSlotRequest(String dcTimeSlot) {
        this.dcTimeSlot = dcTimeSlot;
    }

    public String getDcTimeSlot() {
        return dcTimeSlot;
    }

    public void setDcTimeSlot(String dcTimeSlot) {
        this.dcTimeSlot = dcTimeSlot;
    }

}
