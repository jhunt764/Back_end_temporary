package com.codebrew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebrew.dao.UserRepository;
import com.codebrew.models.User;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create
    public User create(long id, String firstName, String lastName, String church, int zip, String password,
            String username) {
        return UserRepository.save(new User(id, firstName, lastName, church, zip, password, username));
    }

    //retrieve
    public List<User> getAll() {
        return userRepository.findAll();

    }

    //Update
    public User getByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public User update(String firstName, String lastName, String church, int zip, String password){
        User u = userRepository.findByFirstName(firstName);
        u.setLastName(lastName);
        u.setChurch(church);
        u.setZip(zip);
        u.setPassword(password);
    }

    //delete
    public void deleteAll(String username) {
        userRepository.deleteAll();
    }

    public void delete(String firstName) {
        User u = userRepository.findByFirstName(firstName);
        userRepository.delete(u);
    }

}