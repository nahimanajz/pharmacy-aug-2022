package com.pharmacy.model;

public class UserModel {
 private String username;
    private int  password;
    private String phoneNumber;
    private String  gender;
    private String fname;
    private String lname;
    private int age;
    private String  usertype;
    private int retype_password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserPassword() {
        return password;
    }
     public int setRetype_password(int password) {
        return this.password = password;
    }
     public int getRetype_password(){
         return retype_password;
     }
     
    public void setUserPassword(int userPassword) {
        this.password = userPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserRole() {
        return usertype;
    }

    public void setUserRole(String userRole) {
        this.usertype = userRole;
    }
}
