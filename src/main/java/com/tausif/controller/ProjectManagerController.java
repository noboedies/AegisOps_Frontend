package com.tausif.controller;

import com.tausif.beans.ProjectManager;
import com.tausif.services.ProjectManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pm")
public class ProjectManagerController {

    @Autowired
    private ProjectManagerService pmService;

    @GetMapping("/manager-dashboard")
    public String managerDashboard(HttpSession session, RedirectAttributes ra){
        ProjectManager pm = (ProjectManager) session.getAttribute("pm");
        if(pm == null){
            ra.addFlashAttribute("error", "please login first");
            return "redirect:/login";
        }else{
            return "manager/manager-dashboard";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra, HttpSession session){
        ProjectManager pm = pmService.login(username, password);
        if(pm != null){
            session.setAttribute("pm", pm);
            return "redirect:/pm/manager-dashboard";
        }else{
            ra.addFlashAttribute("error", "wrong Credentials");
            return "redirect:/login";
        }
    }
}
