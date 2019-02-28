package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

}
