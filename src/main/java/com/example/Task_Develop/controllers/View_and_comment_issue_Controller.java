package com.example.Task_Develop.controllers;

import com.example.Task_Develop.configure_securityWeb.WebSecurityConfig;
import com.example.Task_Develop.models.Comments;
import com.example.Task_Develop.models.Model_Stat;
import com.example.Task_Develop.repositoryes.Comments_rep;
import com.example.Task_Develop.repositoryes.Model_Stat_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class View_and_comment_issue_Controller {
    @Autowired
    WebSecurityConfig web;
    private String username;
    @Autowired
    private Model_Stat_repository stat;
    @Autowired
    private Comments_rep commt;

    @GetMapping("/View_and_comment_issue/{id}")
    public String viewPost(@PathVariable(value = "id") long id, Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        Optional<Model_Stat> modelstat = stat.findById(id);
        ArrayList<Model_Stat> res = new ArrayList<>();
        modelstat.ifPresent(res::add);
        model.addAttribute("stat", res);
        ArrayList<Long> comments = new ArrayList<Long>();
        ArrayList<Long> comments_temp = new ArrayList<Long>();
        ArrayList<Comments> result = new ArrayList<>();
        for(Model_Stat i : res){
            if(i.getComment() != null)
            comments_temp = i.function_list();
            else
            {
                model.addAttribute("no_comment", "No comment");
                return "View_and_comment_issue";
            }
        }
        for(Long iter  : comments_temp)
        {
            Optional<Comments> comm = commt.findById(iter);
            comm.ifPresent(result::add);
        }
        model.addAttribute("comments", result);
        return "View_and_comment_issue";
    }

    @PostMapping("/View_and_comment_issue/{id}")
    public String adComment(@PathVariable(value = "id") long id, @RequestParam String status,
                            @RequestParam String author,
                            @RequestParam String text, Model model) {
        username = web.getCurrentUsername();
        model.addAttribute("username", username);
        Date date = new Date();
        Comments commentar = new Comments(author, text, date);
        commt.save(commentar);
        Optional<Model_Stat> modelstat = stat.findById(id);
        ArrayList<Model_Stat> res = new ArrayList<>();
        Model_Stat models = new Model_Stat();
        modelstat.ifPresent(res::add);
        for (Model_Stat i : res) {
            i.setStatus(status);
            if(i.getComment() == null) {
                i.setComment(commentar.getId().toString());
            }
            else
            {
                String s = i.getComment();
                String s_1 = commentar.getId().toString();
                i.setComment(s + ' ' + s_1);
            }
            stat.save(i);
        }
        model.addAttribute("stat", res);
        ArrayList<Long> comments = new ArrayList<Long>();
        ArrayList<Long> comments_temp = new ArrayList<Long>();
        ArrayList<Comments> result = new ArrayList<>();
        for(Model_Stat i : res){
            comments_temp = i.function_list();
        }
        for(Long iter  : comments_temp)
        {
            Optional<Comments> comm = commt.findById(iter);
            comm.ifPresent(result::add);
        }
        model.addAttribute("comments", result);
        return "redirect:/View_and_comment_issue/{id}";
    }
}
