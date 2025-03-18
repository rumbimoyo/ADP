package repository;

/*
repository.userRepository
User Repository class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import domain.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {

    private static UserRepository instance;
    private Set<User> userDB;

    public UserRepository(){
        userDB = new HashSet<User>();
    }

    public static synchronized UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    // to add user to database
    public boolean create(User user){
        return userDB.add(user);
    }

    // finds user object based on userID
    public User read(String userID){
        for(User user: userDB){
            if(user.getUserID().equalsIgnoreCase(userID)){
                return user;
            }
        }
        return null; // if no user is found
    }

    // updates object by finding object id
    public User update(User newUser){
        User oldUser = this.read(newUser.getUserID());
        if(oldUser != null){
            userDB.remove(oldUser);
            userDB.add(newUser);
            return newUser;
        }
        return null;
    }

    // deletes user object based on userID
    public void delete(String userID){
        User user = this.read(userID);
        if(user != null){
            userDB.remove(user);
        }
    }

    public Set<User> getAll(){
        return userDB;
    }

}
