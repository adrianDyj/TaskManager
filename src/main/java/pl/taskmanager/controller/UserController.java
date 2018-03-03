package pl.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.taskmanager.model.User;
import pl.taskmanager.service.impl.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "registerForm";
        else {
            if (userServiceImpl.getAll().contains(user)) {
                model.addAttribute("error", "User with email " + user.getEmail() + " already exists.");
                return "registerForm";
            } else {
                userServiceImpl.addWithDefaultRole(user);
                return "registerSuccess";
            }
        }
    }
}
