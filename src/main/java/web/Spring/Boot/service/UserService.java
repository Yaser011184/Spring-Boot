package web.Spring.Boot.service;


import web.Spring.Boot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findUserById(Integer id);

    void update(User user);

    void deleteUserById(Integer id);

    List<User> getUsers();
}
