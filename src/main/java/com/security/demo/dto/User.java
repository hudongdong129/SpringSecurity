package com.security.demo.dto;

import java.util.Date;

public class User {

    private String username;

    private String password;

    private String id;

    private Date birthday;

    public User(String username, String password, String id, Date birthday) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
