package com.is.javatask.people;

import com.is.javatask.people.dto.MailsDto;
import com.is.javatask.people.dto.PeopleDto;
import com.is.javatask.people.model.MailsEntity;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository repository;
    private MailsRepository mailsRepo;
    private AddressesRepository addrRepo;
    private PeopleMapper peopleMapper;

    @Autowired
    public PeopleService(PeopleRepository repository, PeopleMapper peopleMapper,MailsRepository mailsRepo,AddressesRepository addrRepo) {
        this.repository = repository;
        this.peopleMapper = peopleMapper;
        this.addrRepo = addrRepo;
        this.mailsRepo = mailsRepo;
    }

    public List<PeopleDto> searchPeople(String search) {
        return peopleMapper.map(repository.findByFullNameIgnoreCaseContaining(search));
    }

    public void create(PeopleDto peopleDto){
         peopleDto.setId(null);
         PeopleEntity peopleEntity = peopleMapper.map(peopleDto);
         repository.save(peopleEntity);
    }

    public  List<MailsDto> findAllMails(Integer peopleID){
        return  peopleMapper.mapMails( mailsRepo.findByPeopleId(peopleID));
    }


}
