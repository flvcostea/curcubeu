package demo.health.service;

import demo.health.model.User;

import java.util.List;

public interface UserService {
    String addUser(User user);

    List<User> findAllUsers();

    User findById(int id);

    User findByEmail(String emailAddress);

    User updateUser(int id, User user);

    void deleteUser(int id);

    User loginUser(User user);

    User verifyIfExists(User user);
}