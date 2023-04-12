package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Display all employees with email address ""
    List<Employee> findByEmail(String email);

    // Display all employees with firstName "" and lastName "".
    // also show all employees with an email address with ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employee that firstName is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where lastName starts with ""

    List<Employee> findByLastNameStartingWith(String pattern);

}
