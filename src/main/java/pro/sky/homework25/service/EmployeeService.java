package pro.sky.homework25.service;

import org.springframework.context.annotation.Configuration;
import pro.sky.homework25.Employee;
import pro.sky.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.homework25.exception.EmployeeNotFoundException;
import pro.sky.homework25.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Configuration
public class EmployeeService {
    private static final int maxEmployee = 50;
    List<Employee> employees = List.of(
            new Employee("Иванов",
                    "Сергей"),
            new Employee("Петрова",
                    "Анна"),
            new Employee("Степанова",
                    "Раиса"),
            new Employee("Попов",
                    "Станислав"),
            new Employee("Тихонов",
                    "Иван"),
            new Employee("Карпова",
                    "Юлия"),
            new Employee("Морозов",
                    "Егор"),
            new Employee("Хохлов",
                    "Максим"),
            new Employee("Горлова",
                    "Наталья"),
            new Employee("Астахов",
                    "Эдуард")
    );

    public Employee addEmployee(String firstName, String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников!");
        }
        Employee employee = new Employee(firstName, lastName);
        if (!employees.add(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        return employees.stream().filter(employees -> employees.getFirstName().equals(firstName) && employees.getLastName().equals(lastName)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public Set<Employee> getAllEmployees() {
        return (Set<Employee>) employees;
    }
}

