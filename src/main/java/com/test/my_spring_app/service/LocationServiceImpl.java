package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.LocationDAO;
import com.test.my_spring_app.entity.Employee;
import com.test.my_spring_app.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationDAO locationDAO;

    @Autowired
    public LocationServiceImpl(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Override
    public void create(Location location) {
        locationDAO.create(location);
    }

    @Override
    public List<Location> getAll() {
        return locationDAO.getAll();
    }

    @Override
    public Location getById(Long id) {
        return locationDAO.getById(id);
    }

    @Override
    public Location update(Long id, Location location) {
        return locationDAO.update(id,location);
    }

    @Override
    public void delete(Long id) {
        locationDAO.delete(id);
    }
}
