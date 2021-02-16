package com.example.authentication.controllers;

import com.example.authentication.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "greeting";
    }


    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password){
        if (loginService.Authenticate(username, password)){
            return "success";
        }

        return "error";
    }
    
    @GetMapping("/success")
    public String showSuccess(ModelMap map){
        return "success";
        
    }
    
    @GetMapping("/error")
    public String showError(ModelMap map){
        return "error";   
    }
}
