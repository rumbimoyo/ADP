package domain;

/*
domain.User
User entity class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import java.time.LocalDate;

public class User {

    private String userID, name, contactNumber, email, gender;
    private LocalDate dob;

    public User(String s, String johnDoe){

    }

    public User(String userID, String name, LocalDate dob, String gender,
                String contactNumber, String email) {
        this.userID = userID;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getGender(){return gender;}

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder{
        private String userID, name, contactNumber, email, gender;
        private LocalDate dob;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){return new User(userID, name, dob, gender, contactNumber, email);}
    }
}
