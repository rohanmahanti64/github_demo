package com.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class AuthController {

    @GetMapping("/getLocation")
    public String getLocation(){
        return "Bangalore";
    }

    @PostMapping("/postLocation")
    public String postLocation(){
        return "Bangalore";
    }
    @PutMapping("/updateLocation")
    public String updateLocation(){
        return "Bangalore";
    }
public void AuthContoller() {
	// this is demo auth controller.
	System.out.println("Authentication and Authorization provider");
}

@DeleteMapping("/DeleteId")
public String deleteId(){
return "deleted the id successfully";
}
}
