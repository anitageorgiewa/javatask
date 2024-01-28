package com.is.javatask.people;

import com.is.javatask.people.dto.PeopleDto;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository repository;
    private PeopleMapper peopleMapper;

    @Autowired
    public PeopleService(PeopleRepository repository, PeopleMapper peopleMapper) {
        this.repository = repository;
        this.peopleMapper = peopleMapper;
    }

    public List<PeopleDto> searchPeople(String search) {
        return peopleMapper.map(repository.findByFullNameIgnoreCaseContaining(search));
    }

    public void create(PeopleDto peopleDto){
         peopleDto.setId(null);
         PeopleEntity peopleEntity = peopleMapper.map(peopleDto);
         repository.save(peopleEntity);
    }
}
