package com.is.javatask.people.mail;

import com.is.javatask.people.model.PeopleEntity;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_mails")
public class MailsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "t_people_id", nullable = false)
    private PeopleEntity people;

    @Column
    private String mailType;
    @Column
    private String mail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
    }
}
