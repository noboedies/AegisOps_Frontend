package com.tausif.controller;

import com.tausif.beans.User;
import com.tausif.dto.UserLoginDto;
import com.tausif.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/login")
    public String checkLogin(@RequestParam String username,@RequestParam String password, HttpSession session, RedirectAttributes ra){
        User u = userService.checkLogin(username, password);
        if(u == null){
            ra.addFlashAttribute("error", "incorrect username or password");
            return "redirect:/login";
        }
        session.setAttribute("user", u);
        return "redirect:/user-dashboard";

    }



    @GetMapping("/addmanager")
    public String addPm(HttpSession session, RedirectAttributes ra){
        User user = (User) session.getAttribute("user");
        if(user == null){
            ra.addFlashAttribute("error", "Please login first");
            return "login";
        }else{
            return "addmanager";
        }
    }

}
