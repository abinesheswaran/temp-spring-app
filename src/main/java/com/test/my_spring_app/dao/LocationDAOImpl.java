package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;
import com.test.my_spring_app.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO{
    private EntityManager entityManager;

    @Autowired
    public LocationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Location location) {
        entityManager.persist(location);
    }

    @Override
    public List<Location> getAll() {
        TypedQuery<Location> theQuery = entityManager.createQuery("From Location ", Location.class);
        return theQuery.getResultList();
    }

    @Override
    public Location getById(Long id) {
        return entityManager.find(Location.class,id);
    }

    @Override
    public Location update(Long id, Location location) {
        Location theLocation = entityManager.find(Location.class,id);
        theLocation.setName(location.getName());
        theLocation.setFullName(location.getFullName());
        theLocation.setLanguage(location.getLanguage());
        theLocation.setPincode(location.getPincode());
        return entityManager.merge(theLocation);
    }

    @Override
    public void delete(Long id) {
        Location location = entityManager.find(Location.class,id);
        entityManager.remove(location);
    }
}
