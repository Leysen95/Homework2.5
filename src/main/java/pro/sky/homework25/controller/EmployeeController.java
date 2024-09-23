package pro.sky.homework25.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework25.Employee;
import pro.sky.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.homework25.exception.EmployeeNotFoundException;
import pro.sky.homework25.exception.EmployeeStorageIsFullException;
import pro.sky.homework25.service.EmployeeService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
