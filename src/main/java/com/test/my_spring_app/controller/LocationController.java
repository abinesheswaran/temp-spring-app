package com.test.my_spring_app.controller;

import com.test.my_spring_app.entity.Location;
import com.test.my_spring_app.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService employeeService) {
        this.locationService = employeeService;
    }

    @GetMapping("/")
    public List<Location> getAll() {
        return locationService.getAll();
    }

    @PostMapping("/")
    public void create(@RequestBody Location location){
        locationService.create(location);
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable Long id){
        return locationService.getById(id);
    }

    @PostMapping("/{id}")
    public Location update(@PathVariable Long id, @RequestBody Location location){
        return locationService.update(id,location);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        locationService.delete(id);
    }
}
