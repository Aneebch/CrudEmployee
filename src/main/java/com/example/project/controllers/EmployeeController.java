package com.example.project.controllers;


import com.example.project.models.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @GetMapping("/employees")
    public String employees() {
        System.out.println("Employee Controller");
        return "ok";
    }

    @GetMapping
    public List<Employees> getEmployee () {
        var employee = new Employees("Ali");
        var employee2 = new Employees("Herrera");


        List<Employees> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);

        return employeeList;
    }

}
