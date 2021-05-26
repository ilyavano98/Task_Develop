package com.example.Task_Develop.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@Entity
public class Model_Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String author;
    private String full_text;
    private Date data;
    private String comment;

    public Model_Stat() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Model_Stat(String name, String status, String author,String full_text, Date data) {
        this.name = name;
        this.status = status;
        this.author = author;
        this.full_text = full_text;
        this.data = data;
    }

    public ArrayList<Long> function_list(){
        ArrayList<Long> comments = new ArrayList<Long>();
        try (Scanner s = new Scanner(comment)) {
            while (s.hasNextInt()) {
                Long num = s.nextLong();
                System.out.println(num);
                comments.add(num);
            }
        }
        return comments;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public String getFull_text() {
        return this.full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

}
