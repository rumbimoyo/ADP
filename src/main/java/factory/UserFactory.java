package factory;

/*
factory.userFactory
User Factory class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import domain.User;
import util.Helper;
import java.time.LocalDate;
import static util.Helper.*;

public class UserFactory {

    // creates user object with all attributes
    public static User createUser(String userID, String name, LocalDate dob, String gender,
                                  String contactNumber, String email){

        if(!Helper.isValidEmail(email)){
            return null; // if email is invalid
        }

        if(isNullorEmpty(userID) ||
               isNullorEmpty(name) ||
               isNullorEmpty(dob) ||
               isNullorEmpty(gender) ||
               isNullorEmpty(contactNumber) ||
               isNullorEmpty(email)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setDob(dob)
                .setGender(gender)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .build();

    }

    // creates user object with no contact Number
    public static User createUser(String userID, String name, LocalDate dob, String gender, String email){

        if(!Helper.isValidEmail(email)){
            return null; // if email is invalid
        }

        if(isNullorEmpty(userID) ||
                isNullorEmpty(name) ||
                isNullorEmpty(dob) ||
                isNullorEmpty(gender) ||
                isNullorEmpty(email)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setDob(dob)
                .setGender(gender)
                .setEmail(email)
                .build();

    }

    // creates user object with no gender
    public static User createUser(String userID, String name, String email, LocalDate dob,
                                  String contactNumber){

        if(!Helper.isValidEmail(email)){
            return null; // if email is invalid
        }

        if(isNullorEmpty(userID) ||
                isNullorEmpty(name) ||
                isNullorEmpty(dob) ||
                isNullorEmpty(contactNumber) ||
                isNullorEmpty(email)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setDob(dob)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .build();

    }

    // creates user object with no contact number or gender
    public static User createUser(String userID, String name, LocalDate dob, String email){

        if(!Helper.isValidEmail(email)){
            return null; // if email is invalid
        }

        if(isNullorEmpty(userID) ||
                isNullorEmpty(name) ||
                isNullorEmpty(dob) ||
                isNullorEmpty(email)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setDob(dob)
                .setEmail(email)
                .build();

    }

    // creates user object with no email, but has contactNumber
    public static User createUser(String userID, LocalDate dob, String name, String gender,
                                  String contactNumber){

        if(isNullorEmpty(userID) ||
                isNullorEmpty(name) ||
                isNullorEmpty(dob) ||
                isNullorEmpty(gender) ||
                isNullorEmpty(contactNumber)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setDob(dob)
                .setGender(gender)
                .setContactNumber(contactNumber)
                .build();

    }



}
