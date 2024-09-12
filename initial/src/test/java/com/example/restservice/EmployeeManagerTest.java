package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    void testGetAllEmployees() {
        // Act
        Employees result = employeeManager.getAllEmployees();

        // Assert
        assertNotNull(result);
        assertFalse(result.getEmployeeList().isEmpty());
        assertEquals(3, result.getEmployeeList().size()); // Assuming the static block adds 3 employees
    }

    @Test
    void testAddEmployee() {
        // Arrange
        Employee newEmployee = new Employee(4, "Test", "User", "test@example.com");

        // Act
        employeeManager.addEmployee(newEmployee);

        // Assert
        Employees result = employeeManager.getAllEmployees();
        assertEquals(4, result.getEmployeeList().size());
        assertTrue(result.getEmployeeList().contains(newEmployee));
    }
}

class EmployeeTest {

    @Test
    void testEmployeeConstructorAndGetters() {
        // Arrange
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john@example.com";

        // Act
        Employee employee = new Employee(id, firstName, lastName, email);

        // Assert
        assertEquals(id, employee.getId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(email, employee.getEmail());
    }

    @Test
    void testEmployeeSetters() {
        // Arrange
        Employee employee = new Employee();

        // Act
        employee.setId(1);
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employee.setEmail("jane@example.com");

        // Assert
        assertEquals(1, employee.getId());
        assertEquals("Jane", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("jane@example.com", employee.getEmail());
    }
}