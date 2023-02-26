package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {

    // assume we are getting data from db
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Mike", "Smith", 55);
        return employee.getHourlyRate();
    }
}
