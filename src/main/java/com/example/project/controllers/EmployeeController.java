package com.example.project.controllers;


import com.example.project.models.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    List<Employees> employeesList = new ArrayList<>(
            List.of(new Employees("Ali"),new Employees("Herrera")
                    ,new Employees("Wi Tu Lo"), new Employees("Ho Lee Fuk")
                    ,new Employees("Bang Ding Ow"))
    );

    @GetMapping("/employees")
    public String employees() {
        System.out.println("Employee Controller");
        return "ok";
    }

    @GetMapping
    public List<Employees> getEmployee () {

        return this.employeesList;
    }

    @GetMapping("/{id}")
    public Employees getById(@PathVariable UUID id) {

        return this.employeesList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
    }
}
