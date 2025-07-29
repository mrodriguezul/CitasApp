package com.mrodriguezul.citasapp.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @GetMapping("/test")
    public String test(){
        return "Hello from DoctorController";
    }

}
