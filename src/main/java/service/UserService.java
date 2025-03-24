package service;

/*
service.UserService
User Service class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.*;
import repository.*;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    // for implementation of singleton
    private final UserRepository urepo = UserRepository.getInstance();

    // adds user to repository
    public void addUser(User user){
        urepo.create(user);
    }

    // finding other user based on id
    public User findUser(String userID){
        return urepo.read(userID);
    }

    // editing user profile
    public User editUser(User user){
        return urepo.update(user);
    }

    public void deleteProfile(String userID){
        urepo.delete(userID);
    }

}
