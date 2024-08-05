package com.example.First_project.user;

import java.util.List;

import org.springframework.web.service.annotation.GetExchange;

public interface UserHttpClient {

    @GetExchange("/users")
    List<User> finadAll();

    @GetExchange("/users/{id}")
    User findById(Integer id);
}
