package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@Component
public class Dimensions {

    private int width = 10;
    private int height = 30;
    private int depth = 40;

    private void pressPowerButton() {
        System.out.println("Power button pressed");
    }
}
