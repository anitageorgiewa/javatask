package com.is.javatask.people.dto;

import java.util.List;

public class ContactsDto {
    private List<MailsDto> mails;
    private MailsDto mail;
    private AddressesDto address;

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

    private List<AddressesDto> addresses;

    public ContactsDto(List<MailsDto> mails, List<AddressesDto> addresses) {
        this.mails = mails;
        this.addresses = addresses;
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
