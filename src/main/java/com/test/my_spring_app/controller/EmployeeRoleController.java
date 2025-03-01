package com.test.my_spring_app.controller;

import com.test.my_spring_app.entity.EmployeeRole;
import com.test.my_spring_app.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee_role")
public class EmployeeRoleController {
    private EmployeeRoleService employeeRoleService;

    @Autowired
    public EmployeeRoleController(EmployeeRoleService employeeRoleService) {
        this.employeeRoleService = employeeRoleService;
    }

    @GetMapping
    public List<EmployeeRole> getAllEmployeeRole() {
        return employeeRoleService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeRole getEmployeeRole(@PathVariable int id) {
        return employeeRoleService.getById(id);
    }

    @GetMapping("/{employeeId}")
    public EmployeeRole getEmployeeRoleByEmployeeId(@PathVariable int employeeId) {
        return employeeRoleService.getEmployeeRoleByEmployeeId(employeeId);
    }

    @PostMapping()
    public void addEmployeeRole(@RequestBody EmployeeRole employeeRole) {
        employeeRoleService.add(employeeRole);
    }

    @PutMapping("/{id}")
    public void updateEmployeeRole(@PathVariable int id, @RequestBody EmployeeRole employeeRole) {
        employeeRoleService.update(employeeRole, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeRole(@PathVariable int id) {
        employeeRoleService.delete(id);
    }

}
