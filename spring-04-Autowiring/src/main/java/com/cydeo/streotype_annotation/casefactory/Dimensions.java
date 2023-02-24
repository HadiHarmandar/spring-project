package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    private void pressPowerButton() {
        System.out.println("Power button pressed");
    }
}
