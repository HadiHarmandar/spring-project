package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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
    List<Employee> findByLastNameStartsWith(String pattern);

    // Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    // Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries greater and equal to "" in order - salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have an email address
    List<Employee> findByEmailIsNull();

    @Query("select e from Employee e where e.email= 'amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'amcnee1@google.es'")
    Integer retrieveEmployeeSalary();


}
