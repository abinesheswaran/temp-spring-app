package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Location;

import java.util.List;

public interface LocationDAO {
    public void create(Location location);

    public List<Location> getAll();

    public Location getById(Long id);

    public Location update(Long id, Location location);

    public void delete(Long id);
}
