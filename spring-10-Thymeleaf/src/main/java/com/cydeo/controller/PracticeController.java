package com.cydeo.controller;

import com.cydeo.model.Practice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/practice")
public class PracticeController {

    @GetMapping("/form")
    public String getPage(Model model) {

        List<String> states = Arrays.asList("TN", "CA", "VA", "TX");

        model.addAttribute("practice", new Practice());
        model.addAttribute("states", states);

        return "practice/page";
    }

    @PostMapping("/confirm")
    public String confirmPage(@ModelAttribute("practice") Practice practice) {

        return  "practice/confirm-page";
    }

}
