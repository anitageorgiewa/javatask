package com.is.javatask.people.mail;

import com.is.javatask.people.PeopleRepository;
import com.is.javatask.people.model.Mappers;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private MailsRepository mailsRepository;
    private Mappers mappers;
    private PeopleRepository peopleRepository;

    @Autowired
    public MailService(MailsRepository mailsRepository, Mappers mappers, PeopleRepository peopleRepository) {
        this.mailsRepository = mailsRepository;
        this.mappers = mappers;
        this.peopleRepository = peopleRepository;
    }

    public void editMail(MailsDto mail) {

        MailsEntity mailsEntity = mailsRepository.getReferenceById(mail.getId());
        mailsEntity.setMailType(mail.getMailType());
        mailsEntity.setMail(mail.getMail());

        mailsRepository.save(mailsEntity);

    }

    public Integer deleteMail(Integer id) {
        Integer peopleId = mailsRepository.getReferenceById(id).getPeople().getId();
        mailsRepository.deleteById(id);
        return peopleId;
    }

    public Integer createMail(MailsDto mailsDto) {
        PeopleEntity people = peopleRepository.getReferenceById(mailsDto.getPeopleId());
        MailsEntity mailsEntity = mappers.map(mailsDto, people);
        people.addMail(mailsEntity);
        mailsRepository.save(mailsEntity);
        return mailsEntity.getPeople().getId();
    }

    public MailsDto getMails(Integer id) {
        return mappers.map(mailsRepository.getReferenceById(id));
    }

}
