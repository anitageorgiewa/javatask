package com.is.javatask.people.dto;

public class FullProfileDto {
    PeopleDto person;
    MailsDto mail;
    AddressesDto address;

    public FullProfileDto(PeopleDto person, MailsDto mail, AddressesDto address) {
        this.person = person;
        this.mail = mail;
        this.address = address;
    }

    public PeopleDto getPerson() {
        return person;
    }

    public void setPerson(PeopleDto person) {
        this.person = person;
    }

    public MailsDto getMail() {
        return mail;
    }

    public void setMail(MailsDto mail) {
        this.mail = mail;
    }

    public AddressesDto getAddress() {
        return address;
    }

    public void setAddress(AddressesDto address) {
        this.address = address;
    }
}
