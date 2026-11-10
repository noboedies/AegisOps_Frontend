package com.tausif.controller;

import com.tausif.beans.ProjectManager;
import com.tausif.beans.TeamLead;
import com.tausif.services.ProjectManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/addTl")
    public String addTeamLead(HttpSession session, RedirectAttributes ra){
        ProjectManager pm = (ProjectManager) session.getAttribute("pm");
        if(pm == null){
            ra.addFlashAttribute("error", "entry denied Please Login First!");
            return "redirect:/login";
        }
        return "manager/addteamlead";
    }

    @PostMapping("/registerTl")
    public String registerTl(@ModelAttribute TeamLead teamLead,
                             @RequestPart(required = false)MultipartFile profilePic,
                             @RequestPart(required = false) MultipartFile id,
                             RedirectAttributes ra,
                             HttpSession session) throws IOException {
        ProjectManager pm = (ProjectManager) session.getAttribute("pm");
        if(pm == null){
            ra.addFlashAttribute("error", "Please login first!");
            return "redirect:/login";
        }
        teamLead.setProfile(profilePic.getBytes());
        teamLead.setIdCard(id.getBytes());
        TeamLead tl = pmService.registerTl(teamLead);
        if(tl == null){
            ra.addFlashAttribute("error", "Account already exist!");
            return "redirect:/pm/addTl";
        }else{
            ra.addFlashAttribute("success", "Team Lead Account created Successfully!");
            return "redirect:/pm/addTl";
        }
    }

    @GetMapping("/viewTeamLead/{email}")
    public String viewTeamLead(@PathVariable String email, HttpSession session, RedirectAttributes ra){
        ProjectManager pm = (ProjectManager) session.getAttribute("pm");
        if(pm == null){
            ra.addFlashAttribute("error", "Please login first!");
            return "redirect:/login";
        }
        List<TeamLead> teamLeads = pmService.getAllTeamLeadByPmEmail(email);
        return "";
    }
}
