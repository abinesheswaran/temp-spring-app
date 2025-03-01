drop table employee;
drop table employee_role;
drop table role;
drop table team;
drop table vehicle;

select * from employee;
select * from employee_role;
select * from role;
select * from team;
select * from vehicle;

select employee.name, vehicle.make, vehicle.model, vehicle.year, vehicle.color from employee 
inner join vehicle on employee.vehicle_id = vehicle.id;
