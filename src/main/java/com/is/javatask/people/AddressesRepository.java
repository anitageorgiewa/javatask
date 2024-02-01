package com.is.javatask.people;

import com.is.javatask.people.model.AddressesEntity;
import com.is.javatask.people.model.MailsEntity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name="t_addresses" )
public interface AddressesRepository extends JpaRepository<AddressesEntity,Integer> {
    @Query(
            value = """
               SELECT m FROM AddressesEntity m WHERE m.people.id = :peopleId      
            """
    )
    List<AddressesEntity> findByPeopleId(@Param("peopleId")Integer peopleId);
    @Query(
            value = """
               UPDATE  t_addresses 
               set addr_type = :address.addrType
              ,addr_infor = :address.addrInfo
               WHERE t_people_id = :address.peopleId;
            """, nativeQuery = true
    )
    AddressesEntity updateById(AddressesEntity address);

}
