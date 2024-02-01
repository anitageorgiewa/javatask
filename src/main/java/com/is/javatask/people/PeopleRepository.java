package com.is.javatask.people;

import com.is.javatask.people.model.PeopleEntity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name ="t_people")
public interface PeopleRepository extends JpaRepository<PeopleEntity,Integer> {
    //Not optimal, it doesn't use the index
    List<PeopleEntity> findByFullNameIgnoreCaseContaining(String fullName);
    @Query(
            value = """
               UPDATE  t_people
               set full_name = :person.fullName
               , pin =  :person.pin
               WHERE id = :person.id;
                 
            """, nativeQuery = true
    )
    PeopleEntity updateById(PeopleEntity person);
}
