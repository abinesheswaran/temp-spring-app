package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAll();

    public Vehicle getById(int id);

    public void add(Vehicle vehicle);

    public void update(Vehicle vehicle, int id);

    public void delete(int id);
}
