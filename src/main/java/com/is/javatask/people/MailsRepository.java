package com.is.javatask.people;

import com.is.javatask.people.model.MailsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailsRepository extends JpaRepository<MailsEntity,Integer> {
    @Query(
            value = """
               SELECT m FROM MailsEntity m WHERE m.people.id = :peopleId      
            """
    )
    List<MailsEntity> findByPeopleId(@Param("peopleId") Integer peopleId);
    MailsEntity updateById(Integer id);

}
