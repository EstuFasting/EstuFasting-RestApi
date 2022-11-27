package edu.estu.estufastingrestapi.core.repository.helper;

import edu.estu.estufastingrestapi.core.domain.helper.PropertiesFileHelper;
import edu.estu.estufastingrestapi.core.domain.helper.StringTools;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.NotSupportedException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@UtilityClass
public class DatabaseCreator {

    private final String queryKey = "database-creator.query.%s".formatted(JDBCHelper.getDbProductName().map(String::toLowerCase).orElse("default"));
    private final String[] possibleSqlStatesToCreate = {"3D000", "42000"};

    public void create(SQLException connectionException) {
        if (JDBCHelper.getServerConnection() == null) return;
        String message = connectionException.getMessage();
        if (Arrays.stream(possibleSqlStatesToCreate).anyMatch(state -> state.equals(connectionException.getSQLState())))
            getQuery(message).ifPresentOrElse(query -> {
                log.info("Creating Database: '{}'", query);
                try (Statement statement = JDBCHelper.getServerConnection().createStatement()) {
                    statement.execute(query);
                } catch (SQLException e) {
                    log.error(e.getLocalizedMessage());
                }
            }, () -> log.warn("Cannot be found the key '{}'. Stopping database creation attempt.", queryKey));
    }

    @SneakyThrows(NotSupportedException.class)
    private Optional<String> getQuery(String exceptionMessage) {
        String dbName = StringTools.extract(exceptionMessage, "'[^']+'|\"[^\"]+\"")
                .map(name -> name.substring(1, name.length() - 1))
                .orElseThrow(NotSupportedException::new);
        return PropertiesFileHelper.getByKey(queryKey).map(value -> value.replace("{database_name}", dbName));
    }

}
