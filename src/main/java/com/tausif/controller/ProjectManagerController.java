package com.tausif.controller;

import com.tausif.beans.ProjectManager;
import com.tausif.services.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pm")
public class ProjectManagerController {

    @Autowired
    private ProjectManagerService pmService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra){
        ProjectManager pm = pmService.login(username, password);
    }
}
