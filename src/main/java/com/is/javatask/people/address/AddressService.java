package com.is.javatask.people.address;

import com.is.javatask.people.PeopleRepository;
import com.is.javatask.people.model.Mappers;
import com.is.javatask.people.model.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private PeopleRepository peopleRepository;
    private AddressesRepository addressesRepository;
    private Mappers mappers;

    @Autowired
    public AddressService(PeopleRepository peopleRepository, AddressesRepository addressesRepository, Mappers mappers) {
        this.peopleRepository = peopleRepository;
        this.addressesRepository = addressesRepository;
        this.mappers = mappers;
    }

    public void createAddress(AddressesDto addressesDto) {
        PeopleEntity people = peopleRepository.getReferenceById(addressesDto.getPeopleId());
        AddressesEntity addressesEntity = mappers.map(addressesDto, people);
        addressesRepository.save(addressesEntity);
    }

    public AddressesDto getAddress(Integer id) {
        return mappers.map(addressesRepository.getReferenceById(id));
    }

    public Integer deleteAddress(Integer id) {
        Integer peopleId = addressesRepository.getReferenceById(id).getPeople().getId();
        addressesRepository.deleteById(id);
        return peopleId;
    }

    public void editAddress(AddressesDto address) {

        AddressesEntity addressesEntity = addressesRepository.getReferenceById(address.getId());
        addressesEntity.setAddrInfo(address.getAddrInfo());
        addressesEntity.setAddrType(address.getAddrType());

        addressesRepository.save(addressesEntity);

    }
}
