package com.is.javatask.people.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class FullInfoDto {
    private Integer idMail;
    private Integer idAddresses;
    @NotNull
    private Integer peopleId;
    @Length(max = 5)
    private String addrType;
    @Length(max = 10)
    private String addrInfo;
    @Length(max = 5)
    private String mailType;

    @Length(max = 40)
    private String mail;
    @NotBlank
    @Length(max = 90)
    private String fullName;
    @NotBlank
    @Length(min = 10, max = 10)
    private String pin;

    public Integer getIdMail() {
        return idMail;
    }

    public void setIdMail(Integer idMail) {
        this.idMail = idMail;
    }

    public Integer getIdAddresses() {
        return idAddresses;
    }

    public void setIdAddresses(Integer idAddresses) {
        this.idAddresses = idAddresses;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
