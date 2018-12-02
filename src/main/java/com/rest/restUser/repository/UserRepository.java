/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restUser.repository;

import com.rest.restUser.model.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Slawek
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByLogin(String login);
    List<User> findAllBysurname(String surname);
    User findById(long id);
}

