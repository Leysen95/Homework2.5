package pro.sky.homework25.service;

import pro.sky.homework25.Employee;

import java.util.Collection;

public interface EmployeeService {

    public Employee addEmployee(String firstName, String lastName);

    public Employee removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);


    Collection<Employee> getAllEmployees();
}

