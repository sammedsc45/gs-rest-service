package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initializes mocks
    }

    @Test
    void testGetEmployees() {
        // Arrange
        Employees mockEmployees = new Employees();
        mockEmployees.getEmployeeList().add(new Employee(1, "John", "Doe", "john@example.com"));

        // Mock the behavior of employeeManager.getAllEmployees()
        when(employeeManager.getAllEmployees()).thenReturn(mockEmployees);

        // Act
        Employees result = employeeController.getEmployees();

        // Assert
        assertNotNull(result);  // Ensure result is not null
        assertEquals(1, result.getEmployeeList().size());  // Check if there's exactly 1 employee
        assertEquals("John", result.getEmployeeList().get(0).getFirstName());  // Verify employee details
    }

    @Test
    void testGetEmployees_EmptyList() {
        // Arrange
        Employees emptyEmployees = new Employees();  // Create empty Employees object
        when(employeeManager.getAllEmployees()).thenReturn(emptyEmployees);  // Mock empty list

        // Act
        Employees result = employeeController.getEmployees();

        // Assert
        assertNotNull(result);
        assertTrue(result.getEmployeeList().isEmpty());  // Verify that the employee list is empty
    }

    @Test
    void testAddEmployee() {
        // Arrange
        Employee newEmployee = new Employee(null, "Jane", "Doe", "jane@example.com");
        doNothing().when(employeeManager).addEmployee(any(Employee.class));  // Mock the addEmployee method

        // Act
        ResponseEntity<Object> response = employeeController.addEmployee(newEmployee);

        // Assert
        assertEquals(201, response.getStatusCodeValue());  // Ensure the response status is 201 (Created)
        verify(employeeManager, times(1)).addEmployee(any(Employee.class));  // Ensure addEmployee was called once
    }

    @Test
    void testAddEmployee_NullEmployee() {
        // Arrange
        Employee nullEmployee = null;

        // Act
        ResponseEntity<Object> response = employeeController.addEmployee(nullEmployee);

        // Assert
        assertEquals(400, response.getStatusCodeValue());  // Assuming the controller returns 400 Bad Request for null input
        verify(employeeManager, never()).addEmployee(nullEmployee);  // Ensure addEmployee was never called
    }
}