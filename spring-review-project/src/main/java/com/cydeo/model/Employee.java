package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {

    private String name;
    private String department;
    private int hourlyRate;
}
