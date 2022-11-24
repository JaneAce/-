package com.example.demo2.pojo;

public class User {

 private String password;
 private String Username;
 private String emailNo;

 private String address;

 private String sex;

 private String phoneNo;

 private String academyName;

 private String className;

 private String birtherDay;

    public User(String password, String username, String emailNo, String address, String sex, String phoneNo, String academyName, String className, String birtherDay) {
        this.password = password;
        Username = username;
        this.emailNo = emailNo;
        this.address = address;
        this.sex = sex;
        this.phoneNo = phoneNo;
        this.academyName = academyName;
        this.className = className;
        this.birtherDay = birtherDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBirtherDay() {
        return birtherDay;
    }

    public void setBirtherDay(String birtherDay) {
        this.birtherDay = birtherDay;
    }

    public String getEmailNo() {
        return emailNo;
    }

    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", Username='" + Username + '\'' +
                ", emailNo='" + emailNo + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", academyName='" + academyName + '\'' +
                ", className='" + className + '\'' +
                ", birtherDay='" + birtherDay + '\'' +
                '}';
    }
}

