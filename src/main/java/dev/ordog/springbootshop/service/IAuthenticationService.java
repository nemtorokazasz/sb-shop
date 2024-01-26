package dev.ordog.springbootshop.service;

import dev.ordog.springbootshop.model.User;

import java.util.Optional;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
