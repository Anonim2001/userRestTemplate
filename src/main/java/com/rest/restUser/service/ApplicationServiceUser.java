/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restUser.service;

import com.rest.restUser.model.User;
import com.rest.restUser.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Slawek
 */
@Service
public class ApplicationServiceUser {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @PostConstruct
    public void init() {
        save(new User(null, "Zbigniew", "Bogacki", "Admin123",  "zbybogacki@email.com", "jakis opis"));
        save(new User(null, "Jan", "Kowalski", "Janusz123", "jankowalski@email.com", "brak opisu"));
        save(new User(null, "Zbigniew2", "Kowalski2", "Janusz321", "zbybogacki@email.com", "brak opisu"));
        save(new User(null, "Zbigniew3", "Kowalski3",  "Janusz231",  "zbybogacki@email.com", "brak opisu"));
    }

    // Motody dla Usera 
    public User getUser(long id) {
        return userRepository.findById(id);
    }

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> getUserBySurname(String surname) {
        return userRepository.findAllBysurname(surname);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public User postUser(User user) {
        return save(new User(user));
    }

    public User deleteUser(long id) {
        User item = userRepository.findById(id);
        userRepository.delete(item);
        return item;
    }

    public User putUser(User item) {

        if (userRepository.findById(item.getId()) != null) {
            return save(item);
        } else {
            return null;
        }
    }

    public User patchUser(long id, Map<String, String> args) {

        User user = userRepository.findById(id);

        args.keySet().stream().forEach((k) -> {
            switch (k) {
                case "name":
                    user.setName(args.get(k));
                    break;
                case "surname":
                    user.setSurname(args.get(k));
                    break;
                case "login":
                    user.setLogin(args.get(k));
                    break;
                case "email":
                    user.setEmail(args.get(k));
                    break;
                case "description":
                    user.setDescription(args.get(k));
                    break;
                default:
            }
        });
        userRepository.saveAndFlush(user);

        return user;
    }

}

