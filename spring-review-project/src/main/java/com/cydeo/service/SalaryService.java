package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public int calculateRegularSalary() {
        return employeeRepository.getHourlyRate() * hoursRepository.getHours();
    }

}
