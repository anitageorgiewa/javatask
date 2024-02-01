package com.is.javatask.people.dto;

import java.util.List;

public class FullProfileDto {
    PeopleDto person;
    List<MailsDto> mails;
    List<AddressesDto> addresses;

    public FullProfileDto(PeopleDto person, List<MailsDto> mails, List<AddressesDto> addresses) {
        this.person = person;
        this.mails = mails;
        this.addresses = addresses;
    }

    public PeopleDto getPerson() {
        return person;
    }

    public void setPerson(PeopleDto person) {
        this.person = person;
    }

    public List<MailsDto> getMails() {
        return mails;
    }

    public void setMails(List<MailsDto> mails) {
        this.mails = mails;
    }

    public List<AddressesDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesDto> addresses) {
        this.addresses = addresses;
    }
}
