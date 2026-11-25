package com.example.HospitalManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class RestAPIController {

    @GetMapping("/all")
    public String helloWorld() {
        return "This is my first API for enabling security";
    }
}
