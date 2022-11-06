package edu.estu.estufastingrestapi;

import edu.estu.estufastingrestapi.core.utilities.CommandPropertiesProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstuFastingRestApiApplication {

    public static void main(String[] args) {
        CommandPropertiesProcessor.preStartup();
        SpringApplication.run(EstuFastingRestApiApplication.class, args);
    }

}
