package com.tausif.controller;

import com.tausif.beans.User;
import com.tausif.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user, RedirectAttributes ra){
        User u = userService.register(user);
        if(u != null){
            ra.addFlashAttribute("success", "user registered successfully!");
            return "redirect:/";
        }else{
            ra.addFlashAttribute("error", "user already exist!");
            return "redirect:/";
        }
    }

}
