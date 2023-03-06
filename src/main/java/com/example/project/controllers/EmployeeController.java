package com.example.project.controllers;


import com.example.project.models.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    List<Employees> employeesList = new ArrayList<>(
            List.of(new Employees("Ali"),new Employees("Herrera")
                    ,new Employees("Wi Tu Lo"), new Employees("Ho Lee Fuk")
                    ,new Employees("Bang Ding Ow"))
    );

    @GetMapping("/employees")
    public String employee() {
        System.out.println("Employee Controller");
        return "ok";
    }

    @GetMapping
    public List<Employees> getEmployee () {

        return this.employeesList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getById(@PathVariable UUID id) {
            for (Employees employee : this.employeesList) {
                if (employee.getId().equals(id)) return new ResponseEntity<>(employee, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
 //       return this.employeesList.stream()
 //               .filter(item -> item.getId().equals(id))
 //               .findFirst().get();
    }

    @PostMapping
    public Employees create(@RequestBody Employees employee){
        this.employeesList.add(employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public Employees deleteById(@PathVariable UUID id){
/*        for (Employees item: this.employeesList){
            if (item.getId().equals(id)) {
                this.employeesList.remove(item);
                return item;
            }
        };
        return null;*/

        var employeeToDelete = this.employeesList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
        this.employeesList.remove(employeeToDelete);
        return employeeToDelete;
    }

    @PutMapping("/{id}")
    public Employees updateById(@PathVariable UUID id, @RequestBody Employees employees){



        for (Employees item: this.employeesList){
            if (item.getId().equals(id)){
                item.setName(employees.getName());
                return item;
            }

        }
        return null;
    }

    @GetMapping("search")
    public List<Employees> searchBy(@RequestParam(required = false) String name) {
        if (name == null) {
            return this.employeesList;
        }
        var filteredEmployees = this.employeesList.stream()
                .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return filteredEmployees;
    }
}
