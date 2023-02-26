package com.cydeo;

import com.cydeo.config.EmployeeConfig;
import com.cydeo.repository.DBEmployeeRepository;
import com.cydeo.repository.RegularHours;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SalaryApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        RegularHours hours = context.getBean(RegularHours.class);
        System.out.println(hours.getHours());

        DBEmployeeRepository dbEmployeeRepository = context.getBean(DBEmployeeRepository.class);
        System.out.println(dbEmployeeRepository.getHourlyRate());

        SalaryService service = context.getBean(SalaryService.class);
        System.out.println(service.calculateRegularSalary());
    }
}
