package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    // Like / Contains / Startswith / Endwith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    // Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    // Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    // Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    // Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate < ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    // NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    // NOT NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    // SORTING in Asc Order
    @Query("SELECT e.salary FROM Employee e ORDER BY e.salary")
    List<Integer> retrieveEmployeeSalaryOrderAsc();


    // SORTING in Desc Order
    @Query("SELECT e.salary FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    // Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    // Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);









}
