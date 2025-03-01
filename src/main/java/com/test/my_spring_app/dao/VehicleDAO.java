package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Vehicle;

import java.util.List;

public interface VehicleDAO {
    public void add(Vehicle vehicle);

    public void update(Vehicle vehicle, int id);

    public void delete(int id);

    public Vehicle getById(int id);

    public List<Vehicle> getAll();
}
