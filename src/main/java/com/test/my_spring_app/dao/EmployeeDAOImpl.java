package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;
import com.test.my_spring_app.entity.Team;
import com.test.my_spring_app.entity.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void add(Employee employee, int teamId) {
        Team team = em.find(Team.class, teamId);
        employee.setTeam(team);
        em.persist(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        Employee theEmployee = em.find(Employee.class, id);
        Vehicle theVehicle = theEmployee.getVehicle();
        theEmployee.setName(employee.getName());
        theEmployee.setSalary(employee.getSalary());
        theEmployee.setAge(employee.getAge());
        theEmployee.setRoleId(employee.getRoleId());
        theVehicle.setMake(employee.getVehicle().getMake());
        theVehicle.setModel(employee.getVehicle().getModel());
        theVehicle.setYear(employee.getVehicle().getYear());
        theVehicle.setColor(employee.getVehicle().getColor());
        theEmployee.setVehicle(theVehicle);
        em.merge(theEmployee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }
}
