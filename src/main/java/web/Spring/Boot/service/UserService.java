package web.Spring.Boot.service;

import web.Spring.Boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findUserById(Integer id);

    User update(User user, Integer id);

    void deleteUserById(Integer id);

    List<User> getUsers();
}
