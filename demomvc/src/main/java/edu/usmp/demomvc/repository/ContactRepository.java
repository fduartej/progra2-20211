package edu.usmp.demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demomvc.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
    
}
