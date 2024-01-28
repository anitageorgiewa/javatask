package com.is.javatask.people;

import com.is.javatask.people.model.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity,Integer> {
    //Not optimal, it doesn't use the index
    List<PeopleEntity> findByFullNameIgnoreCaseContaining(String fullName);
}
