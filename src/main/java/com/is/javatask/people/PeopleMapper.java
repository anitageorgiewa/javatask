package com.is.javatask.people;

import com.is.javatask.people.dto.PeopleDto;
import com.is.javatask.people.model.AddressesEntity;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleMapper {

    public PeopleDto map(PeopleEntity peopleEntity) {
        PeopleDto peopleDto = new PeopleDto();
        peopleDto.setId(peopleEntity.getId());
        peopleDto.setFullName(peopleEntity.getFullName());
        peopleDto.setPin(peopleEntity.getPin());

        return peopleDto;
    }
    public PeopleEntity map(PeopleDto peopleDto) {
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setId(peopleDto.getId());
        peopleEntity.setFullName(peopleDto.getFullName());
        peopleEntity.setPin(peopleDto.getPin());

        return peopleEntity;
    }
    public List<PeopleDto> map(List<PeopleEntity> peopleEntity) {
        List<PeopleDto> peopleDtos = new ArrayList<>(peopleEntity.size());

        peopleEntity.forEach(people -> {
            List<AddressesEntity> addresses = people.getAddresses();
            System.out.println(addresses);
            peopleDtos.add(map(people));
        });

        return peopleDtos;
    }
}
