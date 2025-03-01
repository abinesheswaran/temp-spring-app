package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
    private EntityManager em;

    @Autowired
    public VehicleDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void add(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    @Transactional
    public void update(Vehicle vehicle, int id) {
        Vehicle theVehicle = em.find(Vehicle.class, id);
        theVehicle.setColor(vehicle.getColor());
        theVehicle.setModel(vehicle.getModel());
        theVehicle.setYear(vehicle.getYear());
        theVehicle.setMake(vehicle.getMake());
        theVehicle.setEmployeeId(vehicle.getEmployeeId());
        em.merge(theVehicle);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Vehicle.class, id));
    }

    @Override
    public Vehicle getById(int id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public List<Vehicle> getAll() {
        return em.createQuery("from Vehicle", Vehicle.class).getResultList();
    }
}
