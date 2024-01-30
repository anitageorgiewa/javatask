package com.is.javatask.people;

import com.is.javatask.people.model.AddressesEntity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name="t_addresses" )
public interface AddressesRepository extends JpaRepository<AddressesEntity,Integer> {
}
