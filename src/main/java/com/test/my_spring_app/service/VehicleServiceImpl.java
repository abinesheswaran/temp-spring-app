package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.VehicleDAO;
import com.test.my_spring_app.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleDAO vehicleDAO;
    @Autowired
    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }
    @Override
    public List<Vehicle> getAll() {
        return vehicleDAO.getAll();
    }

    @Override
    public Vehicle getById(int id) {
        return vehicleDAO.getById(id);
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleDAO.add(vehicle);
    }

    @Override
    public void update(Vehicle vehicle, int id) {
        vehicleDAO.update(vehicle, id);
    }

    @Override
    public void delete(int id) {
        vehicleDAO.delete(id);
    }
}
