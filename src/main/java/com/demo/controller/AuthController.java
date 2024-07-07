package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/getLocation")
    public String getLocation(){
        return "Bangalore";
    }

    @PostMapping ("/postLocation")
    public String postLocation(){
        return "Bangalore";
    }
    @PutMapping("/updateLocation")
    public String updateLocation(){
        return "Bangalore";
    }

}

