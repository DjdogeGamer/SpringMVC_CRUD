package br.com.audaxcrud.audax_crud_series;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showLoginPage() {
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }

}

