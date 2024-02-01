package com.is.javatask.people.dto;

import java.util.List;

public class UpdateMailForm {
    List<MailsDto> mails;

    public UpdateMailForm(List<MailsDto> mails) {
        this.mails = mails;
    }

    public List<MailsDto> getMails() {
        return mails;
    }

    public void setMails(List<MailsDto> mails) {
        this.mails = mails;
    }
}
