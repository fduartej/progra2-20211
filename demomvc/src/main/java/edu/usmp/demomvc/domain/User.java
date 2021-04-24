package edu.usmp.demomvc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_user")
public class User {

    @Id
    private String username;
    private String password;



    
}
