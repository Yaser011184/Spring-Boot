package web.Spring.Boot.service;

import org.springframework.stereotype.Service;
import web.Spring.Boot.model.User;
import web.Spring.Boot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional <User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user, Integer id) {
        userRepository.findById(id);
        if (user != null) {
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
