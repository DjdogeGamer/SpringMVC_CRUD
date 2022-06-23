package br.com.audaxcrud.audax_crud_series.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String login() {
        return "series";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
