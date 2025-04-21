package com.prac.pracproj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prac.pracproj.Domain.User;
import com.prac.pracproj.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {
    @Autowired
    UserService service;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String check(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        User user = service.validate(username,password);
        if(user!=null){
            model.addAttribute("name",username);
            return "home";
        }
        else{
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }
    
    
}
