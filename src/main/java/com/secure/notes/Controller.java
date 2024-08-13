package com.secure.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/contact")
    public String sayContact() {
        return "Contact";
    }

}
