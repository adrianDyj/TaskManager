package pl.taskmanager.service;

import pl.taskmanager.model.User;

import java.util.List;

public interface UserService {

    void addWithDefaultRole(User user);

    List<User> getAll();
}
