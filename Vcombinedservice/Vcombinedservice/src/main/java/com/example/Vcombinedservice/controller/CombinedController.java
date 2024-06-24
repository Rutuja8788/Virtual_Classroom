package com.example.Vcombinedservice.controller;



import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combined")
public class CombinedController {

    private final String userServiceUrl = "http://localhost:8080/users";
    private final String classServiceUrl = "http://localhost:8081/classes";

    @PostMapping("/register")
    public String registerUser(@RequestBody String user) {
        HttpResponse<String> response = Unirest.post(userServiceUrl + "/register")
                .header("Content-Type", "application/json")
                .body(user)
                .asString();
        return response.getBody();
    }

    @PostMapping("/createClass")
    public String createClass(@RequestBody String classEntity, @RequestParam String role) {
        if (!"instructor".equals(role)) {
            return "Only instructors can create classes.";
        }

        HttpResponse<String> response = Unirest.post(classServiceUrl + "/create")
                .header("Content-Type", "application/json")
                .queryString("role", role)
                .body(classEntity)
                .asString();
        return response.getBody();
    }
}


