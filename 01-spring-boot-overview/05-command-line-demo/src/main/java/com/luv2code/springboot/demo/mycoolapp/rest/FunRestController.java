package com.luv2code.springboot.demo.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that returns "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return """
                Hello World! This my first Spring Boot code!
                And now it automatically reloads on saves!
                """;
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWork() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune() {
        return "Pleasant news is on its way.";
    }
}
