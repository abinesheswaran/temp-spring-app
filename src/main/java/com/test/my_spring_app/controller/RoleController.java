package com.test.my_spring_app.controller;

import com.test.my_spring_app.entity.Role;
import com.test.my_spring_app.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<Role> getAllRole() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable int id) {
        return roleService.getById(id);
    }

    @PostMapping()
    public void addRole(@RequestBody Role role) {
        roleService.add(role);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable int id, @RequestBody Role role) {
        roleService.update(role, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id) {
        roleService.delete(id);
    }

}
