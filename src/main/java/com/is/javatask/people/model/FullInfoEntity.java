package com.is.javatask.people.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_people")
@SecondaryTables({
        @SecondaryTable(name = "t_mails", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "idMail")}),
        @SecondaryTable(name = "t_addresses", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "idAddresses")})
})

public class FullInfoEntity {

    //  @Column(name="id" ,table = "t_mails")
    private Integer idMail;
    //  @Column(name="id", table ="t_addresses")
    private Integer idAddresses;

    @Column(name = "id", table = "t_people")
    @Id
    private Integer peopleId;
    // @Column(name="addr_type", table ="t_addresses")
    private String addrType;
    //@Column(name="addr_info", table ="t_addresses")
    private String addrInfo;
    //@Column(name="mail_type", table ="t_mails")
    private String mailType;

    @Column(name = "mail", table = "t_mails")
    private String mail;

    // @Column(name="full_name", table ="t_people")
    private String fullName;
    @Column(name = "pin", table = "t_people")
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
