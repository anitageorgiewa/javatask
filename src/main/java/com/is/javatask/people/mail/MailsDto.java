package com.is.javatask.people.mail;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class MailsDto {

    private Integer id;

    @NotNull
    private Integer peopleId;

    @Length(max = 5)
    private String mailType;

    @Length(max = 40)
    private String mail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
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
}
