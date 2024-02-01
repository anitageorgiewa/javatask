package com.is.javatask.people;

import com.is.javatask.people.model.Mappers;
import com.is.javatask.people.model.PeopleEntity;
import com.is.javatask.people.model.dto.ContactsDto;
import com.is.javatask.people.model.dto.PeopleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;
    private Mappers mappers;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, Mappers mappers) {
        this.peopleRepository = peopleRepository;
        this.mappers = mappers;
    }

    public List<PeopleDto> searchPeople(String search) {
        return mappers.map(peopleRepository.findByFullNameIgnoreCaseContaining(search));
    }

    public PeopleEntity create(PeopleDto peopleDto) {
        peopleDto.setId(null);
        PeopleEntity peopleEntity = mappers.map(peopleDto);
        return peopleRepository.save(peopleEntity);
    }

    public ContactsDto getContacts(Integer peopleID) {
        PeopleEntity people = peopleRepository.getReferenceById(peopleID);
        return new ContactsDto(
                mappers.mapMails(people.getMails()),
                mappers.mapAddresses(people.getAddresses())
        );
    }

}
