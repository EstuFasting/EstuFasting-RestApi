package edu.estu.estufastingrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstuFastingRestApiApplication {

    public static void main(String[] args) {
        //CommandPropertiesProcessor.startedEvent();
        //JDBCHelper.testConnection(JDBCHelper.DB_URL, DatabaseCreator::create);
        SpringApplication.run(EstuFastingRestApiApplication.class, args);
    }

}
