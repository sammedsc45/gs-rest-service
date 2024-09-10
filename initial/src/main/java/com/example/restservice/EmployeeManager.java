package com.example.restservice;

import org.springframework
        .stereotype
        .Repository;

// Importing the employees class to
// use the defined properties
// in this class


@Repository

// Class to create a list
// of employees
public class EmployeeManager {

    private static Employees list
            = new Employees();

    // This static block is executed
    // before executing the main
    // block
    static
    {

        // Creating a few employees
        // and adding them to the list
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "Sammed",
                        "Chougule",
                        "sammedchougule@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        2, "Vallabh",
                        "K",
                        "vallabhk@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        3, "Abhishek",
                        "PK",
                        "abhishekpk@gmail.com"));


    }

    // Method to return the list
    public Employees getAllEmployees()
    {

        return list;
    }


    // Method to add an employee
    // to the employees list
    public void
    addEmployee(Employee employee)
    {
        list.getEmployeeList()
                .add(employee);

    }
}