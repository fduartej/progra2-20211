package edu.usmp.demodashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demodashboard.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
}
