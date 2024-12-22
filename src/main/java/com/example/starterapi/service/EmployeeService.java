package com.example.starterapi.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.starterapi.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeService {

    private static final String FILE_PATH = "employees.json";
    private final ObjectMapper objectMapper;

    public EmployeeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Get all employees from the JSON file
    public List<Employee> getEmployees() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Employee addEmployee(Employee employee) {
        List<Employee> employees = getEmployees();
        
        // Check if there fields are populated first
        validateEmployee(employee);

        // Check if email already exists
        for (Employee e : employees) {
            if (e.getEmail().equals(employee.getEmail())) {
                throw new RuntimeException("Email already exists");
            }
        }

        // Add new employee if email is unique
        employee.setEmployeeNo(UUID.randomUUID());
        employees.add(employee);
        saveEmployees(employees);

        return employee;
    }

    // Save employees data back to the JSON file
    private void saveEmployees(List<Employee> employees) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateEmployee(Employee employee) {
        if (employee.getTitle() == null || employee.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (employee.getFirstName() == null || employee.getFirstName().isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (employee.getLastName() == null || employee.getLastName().isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (employee.getDateOfBirth() == null) {
            throw new IllegalArgumentException("Date of birth is required");
        }
        if (employee.getGender() == null || employee.getGender().isBlank()) {
            throw new IllegalArgumentException("Gender is required");
        }
        if (employee.getEmail() == null || employee.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
    }
}
