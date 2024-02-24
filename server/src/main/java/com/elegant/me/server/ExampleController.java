package com.elegant.me.server;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class ExampleController {

    private static final Logger LOGGER = Logger.getLogger(ExampleController.class.getName());

    @GetMapping("/example")
    public String getExample() {
        // Log a message to the server logs
        LOGGER.info("Endpoint /api/example accessed.");

        // Your actual logic here
        return "Hello from Spring Boot!";
    }

}
