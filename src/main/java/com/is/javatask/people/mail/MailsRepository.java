package com.is.javatask.people.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailsRepository extends JpaRepository<MailsEntity, Integer> {
}
