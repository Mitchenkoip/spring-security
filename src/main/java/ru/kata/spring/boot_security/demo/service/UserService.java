package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
    User findById(Long id);
    Optional<User> findByName(String name);
}
