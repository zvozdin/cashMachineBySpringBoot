package ua.com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {
//        todo pass to page according to user role
//        model.addAttribute("roles", EnumSet.allOf(Roles.class));
        return "login";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
