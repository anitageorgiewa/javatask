package com.is.javatask.people;

import com.is.javatask.people.dto.AddressesDto;
import com.is.javatask.people.dto.MailsDto;
import com.is.javatask.people.dto.PeopleDto;
import com.is.javatask.people.model.AddressesEntity;
import com.is.javatask.people.model.MailsEntity;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mappers {

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
            peopleDtos.add(map(people));
        });

        return peopleDtos;
    }

    public MailsDto map(MailsEntity mailsEntity) {
        MailsDto mailsDto = new MailsDto();
        mailsDto.setPeopleId(mailsEntity.getPeople().getId());
        mailsDto.setId(mailsEntity.getId());
        mailsDto.setMail(mailsEntity.getMail());
        mailsDto.setMailType(mailsEntity.getMailType());
        return mailsDto;
    }

    public MailsEntity map(MailsDto mailsDto, PeopleEntity people) {
        MailsEntity mailsEntity = new MailsEntity();
        mailsEntity.setId(mailsDto.getId());
        mailsEntity.setMail(mailsDto.getMail());
        mailsEntity.setPeople(people);
        mailsEntity.setMailType(mailsDto.getMailType());
        return mailsEntity;
    }

    public AddressesDto map(AddressesEntity addressesEntity) {
        AddressesDto addressesDto = new AddressesDto();
        addressesDto.setPeopleId(addressesEntity.getPeople().getId());
        addressesDto.setId(addressesEntity.getId());
        addressesDto.setAddrType(addressesEntity.getAddrType());
        addressesDto.setAddrInfo(addressesEntity.getAddrInfo());
        return addressesDto;
    }
    public AddressesEntity map(AddressesDto addressesDto, PeopleEntity people) {
        AddressesEntity addressesEntity = new AddressesEntity();
        addressesEntity.setPeople(people);
        addressesEntity.setId(addressesDto.getId());
        addressesEntity.setAddrType(addressesDto.getAddrType());
        addressesEntity.setAddrInfo(addressesDto.getAddrInfo());
        return addressesEntity;
    }
    public List<MailsDto> mapMails(List<MailsEntity> mails) {
        List<MailsDto> mailsDto = new ArrayList<>(mails.size());

        mails.forEach(mail -> mailsDto.add(map(mail)));

        return mailsDto;
    }

    public List<AddressesDto> mapAddresses(List<AddressesEntity> addresses) {
        List<AddressesDto> addressesDtos = new ArrayList<>(addresses.size());

        addresses.forEach(address -> addressesDtos.add(map(address)));

        return addressesDtos;
    }

}
