/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restUser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Slawek
 */
@Data
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String login;
    
    private String email;

    private String description;

    public User(User user) {
        this.id = null;
        this.name = user.getName();
        this.surname = user.getSurname();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.description = user.getDescription();
    }
}

