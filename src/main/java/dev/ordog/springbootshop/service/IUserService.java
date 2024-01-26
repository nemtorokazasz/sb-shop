package dev.ordog.springbootshop.service;

import dev.ordog.springbootshop.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);

    void makeUser(String username);
}
