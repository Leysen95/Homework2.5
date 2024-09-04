package pro.sky.homework25.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework25.Employee;
import pro.sky.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.homework25.exception.EmployeeNotFoundException;
import pro.sky.homework25.exception.EmployeeStorageIsFullException;
import pro.sky.homework25.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam String firstName,
                                                @RequestParam String lastName) {
        try {
            return ResponseEntity.ok(employeeService.addEmployee(firstName,lastName));
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Employee> removeEmployee(@RequestParam String firstName,
                                                   @RequestParam String lastName) {
        try {
            return ResponseEntity.ok(employeeService.removeEmployee(firstName,lastName));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee (@RequestParam String firstName,
                                                  @RequestParam String lastName) {
        try {
            return ResponseEntity.ok(employeeService.findEmployee(firstName,lastName));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Employee>> getAllEmployees() {
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
