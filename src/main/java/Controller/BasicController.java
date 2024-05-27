package Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BasicController {
    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Value("${custom.value1}")
    private int value1;

    @Value("${custom.value2}")
    private int value2;

    @GetMapping("/")
    public String welcome() {
        logger.info("Accessed welcome endpoint");
        return "Welcome in my Spring Boot application!";
    }

    @GetMapping("/exp")
    public String calculateExponent() {
        logger.debug("Starting exponent calculation");
        int result = (int) Math.pow(value1, value2);
        logger.debug("Finished exponent calculation");
        return "The result of " + value1 + " raised to the power of " + value2 + " is: " + result;
    }

    @GetMapping("/get-errors")
    public void getErrors() {
        logger.error("Custom exception triggered");
        throw new RuntimeException("This is a custom error");
    }
}