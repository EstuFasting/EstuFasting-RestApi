package edu.estu.estufastingrestapi;

import edu.estu.estufastingrestapi.core.domain.helper.CommandPropertiesProcessor;
import edu.estu.estufastingrestapi.core.repository.helper.DatabaseCreator;
import edu.estu.estufastingrestapi.core.repository.helper.JDBCHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstuFastingRestApiApplication {

    public static void main(String[] args) {
        CommandPropertiesProcessor.startedEvent();
        JDBCHelper.testConnection(JDBCHelper.DB_URL, DatabaseCreator::create);
        SpringApplication.run(EstuFastingRestApiApplication.class, args);
    }

}
