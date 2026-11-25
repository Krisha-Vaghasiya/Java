package com.example.HospitalManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class RestController1 {

    @GetMapping("/allUser")
    public String getAllUser() {
        return "All User list displayed here";
    }

}
