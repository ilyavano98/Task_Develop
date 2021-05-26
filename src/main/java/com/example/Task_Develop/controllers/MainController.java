package com.example.Task_Develop.controllers;


import com.example.Task_Develop.configure_securityWeb.WebSecurityConfig;
import com.example.Task_Develop.models.Model_Stat;
import com.example.Task_Develop.repositoryes.Model_Stat_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
    @Autowired
    WebSecurityConfig web;
    private String username;
    @Autowired
    private Model_Stat_repository stat;

    @GetMapping("/")
    public String home( Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        Iterable<Model_Stat> stats = stat.findAll();
        model.addAttribute("stat", stats);
        return "Index";
    }

    @GetMapping("/home")
    public String home_1( Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        Iterable<Model_Stat> Stat = stat.findAll();
        model.addAttribute("stat", Stat);
        return "Index";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        return "login";
    }

}

