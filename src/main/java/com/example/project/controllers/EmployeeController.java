package com.example.project.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @GetMapping("/employees")
    public String employees() {
        System.out.println("Employee Controller");
        return "ok";
    }



}
