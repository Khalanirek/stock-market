package com.khalanirek.stockmarket.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationTestController {

    @GetMapping
    String test() {
        return "Application is available!";
    }

}
