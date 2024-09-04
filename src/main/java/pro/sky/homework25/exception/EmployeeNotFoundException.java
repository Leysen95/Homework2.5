package pro.sky.homework25.exception;

import pro.sky.homework25.Employee;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
