package com.is.javatask.people;

import com.is.javatask.people.dto.*;
import com.is.javatask.people.model.AddressesEntity;
import com.is.javatask.people.model.MailsEntity;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;
    private Mappers mappers;
    private MailsRepository mailsRepository;
    private AddressesRepository addressesRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, Mappers mappers,MailsRepository mailsRepository,AddressesRepository addressesRepository) {
        this.peopleRepository = peopleRepository;
        this.mappers = mappers;
        this.mailsRepository = mailsRepository;
        this.addressesRepository = addressesRepository;
    }

    public List<PeopleDto> searchPeople(String search) {
        return mappers.map(peopleRepository.findByFullNameIgnoreCaseContaining(search));
    }

    public PeopleEntity create(PeopleDto peopleDto){
         peopleDto.setId(null);
         PeopleEntity peopleEntity = mappers.map(peopleDto);
         return peopleRepository.save(peopleEntity);
    }

    public void edit(FullProfileDto profile){
        PeopleEntity person = peopleRepository.updateById();
        MailsEntity mail = mailsRepository.updateById();
        AddressesEntity address = addressesRepository.updateById();

    }
    public void createMail(MailsDto mailsDto){
        PeopleEntity people = peopleRepository.getReferenceById(mailsDto.getPeopleId());
        MailsEntity mailsEntity = mappers.map(mailsDto,people);
        people.addMail(mailsEntity);
        mailsRepository.save(mailsEntity);
    }
    public void createAddress(AddressesDto addressesDto){
        PeopleEntity people = peopleRepository.getReferenceById(addressesDto.getPeopleId());
        AddressesEntity addressesEntity = mappers.map(addressesDto, people);
        addressesRepository.save(addressesEntity);
    }
    public ContactsDto getContacts(Integer peopleID){
        PeopleEntity people = peopleRepository.getReferenceById(peopleID);
        return new ContactsDto(
                mappers.mapMails(people.getMails()),
                mappers.mapAddresses(people.getAddresses())
        );
    }

}
