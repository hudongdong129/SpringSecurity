package com.security.demo.controller;

import com.security.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public List<User> query() {
        List<User> users = new ArrayList<User>();
        users.add(new User("hdd","123456","1",new Date()));
        return users;
    }

}
