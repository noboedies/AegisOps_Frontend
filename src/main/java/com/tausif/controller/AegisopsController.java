package com.tausif.controller;

import com.tausif.beans.User;
import com.tausif.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AegisopsController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user-dashboard")
    public String userDashboard(HttpSession session, RedirectAttributes ra){
        User user = (User)session.getAttribute("user");
        if(user == null){
            ra.addFlashAttribute("error", "please login first");
            return "redirect:/login";
        }
        return "user-dashboard";

    }
    @GetMapping("/addmanager")
    public String addManager(HttpSession session, RedirectAttributes ra){
        User user = (User)session.getAttribute("user");
        if(user == null){
            ra.addFlashAttribute("error", "Please login first!");
            return "redirect:/login";
        }else{
            return "addmanager";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,
                         RedirectAttributes ra)
    {
        User user = (User) session.getAttribute("user");
        if(user != null){
            session.invalidate();
            return "redirect:/login";
        }else{
            ra.addFlashAttribute("error", "Please login first");
            return "redirect:/login";
        }
    }
}
