package com.example.Task_Develop.controllers;

import com.example.Task_Develop.configure_securityWeb.WebSecurityConfig;
import com.example.Task_Develop.models.Model_Stat;
import com.example.Task_Develop.repositoryes.Model_Stat_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
public class Create_Issues_Controller {
    @Autowired
    WebSecurityConfig web;
    private String username;
    @Autowired
    private Model_Stat_repository stat;

    @GetMapping("/Create_issue")
    public String newPost( Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        return "Create_issue";
    }

    @PostMapping("/Create_issue")
    public String newPost_add(@RequestParam String name, @RequestParam String author,
                              @RequestParam String full_text,
                              Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        String status = "Created";
        Date date = new Date();
        Model_Stat Model_Stat = new Model_Stat(name, status, author, full_text, date);
        stat.save(Model_Stat);
        return "redirect:/home";
    }
}
