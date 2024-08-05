package com.example.First_project.user;

public record User(Integer id, String name, String username, String email, Address address, String phone,
        String website, Company company) {

}
