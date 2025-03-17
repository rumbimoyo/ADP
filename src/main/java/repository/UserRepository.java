package repository;

import domain.User;

import java.util.HashSet;

public class UserRepository {

    private static UserRepository instance;
    private HashSet<User> userDB;

    public UserRepository(){
        userDB = new HashSet<>();
    }

    public static synchronized UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    // to add user to database
    public void create(User user){
        userDB.add(user);
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
        }
        return newUser;
    }

    // deletes user object based on userID
    public void delete(String userID){
        User user = this.read(userID);
        if(user != null){
            userDB.remove(user);
        }
    }

    public HashSet<User> getAll(){
        return userDB;
    }

}
