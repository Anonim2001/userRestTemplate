/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restUser.controler;

import com.rest.restUser.model.User;
import com.rest.restUser.service.ApplicationServiceUser;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Slawek
 */
@RestController
public class AppControllr {

    @Autowired
    ApplicationServiceUser serviceUser;

    @RequestMapping(produces = {"application/json"}, method = RequestMethod.GET, path = "/user")
    public List<User> getUsers() {
        return serviceUser.getUsers();
    }
    
    
    @RequestMapping(produces = {"application/json"}, method = RequestMethod.GET, path = "/user/findbyid/{id}")
    public User getUser(@PathVariable("id") long id) {
        return serviceUser.getUser(id);
    }

    @RequestMapping(produces = {"application/json"}, method = RequestMethod.GET, path = "/user/findbylogin/{login}")
    public User getUserByLogin(@PathVariable("login") String login) {
        return serviceUser.getUserByLogin(login);
    }
    
        @RequestMapping(produces = {"application/json"}, method = RequestMethod.GET, path = "/user/findbysurname/{surname}")
    public List<User> getUserBySurname(@PathVariable("surname") String surname) {
        return serviceUser.getUserBySurname(surname);
    }
    
    @RequestMapping(produces = {"application/json"}, consumes = {"application/json"},
            method = RequestMethod.POST, path = "/user")
    public User postUser(@RequestBody User user) {
        return serviceUser.postUser(user);
    }

    @RequestMapping(produces = {"application/json"}, method = RequestMethod.DELETE, path = "/users/{id}")
    public User deleteUser(@PathVariable("id") long id) {
        return serviceUser.deleteUser(id);
    }


    @RequestMapping(produces = {"application/json"}, method = RequestMethod.PATCH, path = "/users/{id}")
    public User patchItemUser(@PathVariable("id") long id, @RequestBody Map<String, String> args) {
        return serviceUser.patchUser(id, args);
    }
}
