package com.a.redkovsky.carselling.controller;

import com.a.redkovsky.carselling.model.RegistrationForm;
import com.a.redkovsky.carselling.model.Role;
import com.a.redkovsky.carselling.model.User;
import com.a.redkovsky.carselling.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/start"})
    public String startPage() {
        return "start";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration")
    public String register(Model model) {
        model.addAttribute("regForm", new RegistrationForm(true));
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute RegistrationForm regForm) {
        if (Objects.equals(regForm.getPassword(), regForm.getPasswordConfirm())) {
            userService.saveUser(new User(regForm.getUsername(), regForm.getPassword(), Role.ROLE_USER));
            model.addAttribute("name", regForm.getUsername());
            return "redirect:/cars/getAll";
        }
        model.addAttribute("regForm", new RegistrationForm(false));
        return "registration";
    }
}
