package web.Spring.Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.Spring.Boot.model.User;
import web.Spring.Boot.service.UserService;
import web.Spring.Boot.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String userInfo(Principal principal) {
        User user = userServiceImpl.findByUsername(principal.getName());
        return user.getUsername() + " " + user.getAge() + " " + user.getEmail();
    }
}
