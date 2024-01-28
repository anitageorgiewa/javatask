package com.is.javatask.people.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "t_mails")
public class MailsEntity {
    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "t_people_id")
    private Integer peopleId;

    @Column
    @Length(max = 5)
    private String mailType;
    @Column
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
