package com.tausif.controller;

import com.tausif.beans.ProjectManager;
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

    @PostMapping("/addpm")
    public String addPm(@ModelAttribute ProjectManager pm, RedirectAttributes ra){
        ProjectManager projectManager = userService.registerPm(pm);
        if(projectManager == null) {
            ra.addFlashAttribute("error", "account already exist!");
            return "redirect:/login";
        }else{
            ra.addFlashAttribute("success", "account created successfully!");
            return "redireect:/addmanager";
        }
    }
}
