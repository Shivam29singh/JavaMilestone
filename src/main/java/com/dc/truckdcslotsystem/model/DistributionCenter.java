package com.dc.truckdcslotsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class DistributionCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="dcNumber")
    private Long dcNumber;


    @Column(name = "dcCity")
    @NotNull
    private String dcCity;


    @Column(name = "dctype")
    @NotNull
    private String dctype;

    public DistributionCenter() {
    }

    public DistributionCenter(Long dcNumber, String dcCity, String dctype) {
        this.dcNumber = dcNumber;
        this.dcCity = dcCity;
        this.dctype = dctype;
    }

    public Long getDcNumber() {
        return dcNumber;
    }

    public void setDcNumber(Long dcNumber) {
        this.dcNumber = dcNumber;
    }

    public String getDcCity() {
        return dcCity;
    }

    public void setDcCity(String dcCity) {
        this.dcCity = dcCity;
    }

    public String getDctype() {
        return dctype;
    }

    public void setDctype(String dctype) {
        this.dctype = dctype;
    }

    @Override
    public String toString() {
        return "DistributionCenter{" +
                "dcNumber=" + dcNumber +
                ", dcCity='" + dcCity + '\'' +
                ", dctype='" + dctype + '\'' +
                '}';
    }
}
