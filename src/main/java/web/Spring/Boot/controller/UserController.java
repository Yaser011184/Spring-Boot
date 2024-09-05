package web.Spring.Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Spring.Boot.model.User;
import web.Spring.Boot.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAll(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{id}")
        public String showFormForUpdate (@PathVariable(value = "id") Integer id, Model model){
        User user = userService.findUserById(id);
            model.addAttribute("user", user);
            return "updateUser";
        }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        this.userService.deleteUserById(id);
        return "redirect:/";
    }
}
