package com.test.my_spring_app.controller;

import com.test.my_spring_app.entity.Vehicle;
import com.test.my_spring_app.service.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public List<Vehicle> getAllVehicle() {
        return vehicleService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable int id) {
        return vehicleService.getById(id);
    }

    @PostMapping()
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.add(vehicle);
    }

    @PutMapping("/{id}")
    public void updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int id) {
        vehicleService.update(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleService.delete(id);
    }
}
