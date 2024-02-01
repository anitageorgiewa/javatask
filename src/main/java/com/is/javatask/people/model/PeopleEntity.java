package com.is.javatask.people.model;

import com.is.javatask.people.address.AddressesEntity;
import com.is.javatask.people.mail.MailsEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_people")
public class PeopleEntity {
    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String fullName;
    @Column
    private String pin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "people")
    private List<AddressesEntity> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "people")
    private List<MailsEntity> mails = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<AddressesEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesEntity> addresses) {
        this.addresses = addresses;
    }

    public List<MailsEntity> getMails() {
        return mails;
    }

    public void setMails(List<MailsEntity> mails) {
        this.mails = mails;
    }

    public void addMail(MailsEntity mail) {
        this.mails.add(mail);
    }
}
