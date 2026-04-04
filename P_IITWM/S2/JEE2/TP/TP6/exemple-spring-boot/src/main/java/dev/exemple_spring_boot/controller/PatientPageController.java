package dev.exemple_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientPageController {

    @GetMapping("/patients-ui")
    public String patientsPage() {
        return "patients";
    }
}

