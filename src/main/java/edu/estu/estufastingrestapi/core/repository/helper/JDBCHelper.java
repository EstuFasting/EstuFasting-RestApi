package edu.estu.estufastingrestapi.core.repository.helper;

import edu.estu.estufastingrestapi.core.domain.helper.CommandPropertiesProcessor;
import edu.estu.estufastingrestapi.core.domain.helper.PropertiesFileHelper;
import edu.estu.estufastingrestapi.core.domain.helper.ThreadHelper;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
@UtilityClass
public class JDBCHelper {

    public final String DB_URL = PropertiesFileHelper.getByKey("spring.datasource.url").orElseThrow();
    public final String SERVER_URL = DB_URL.transform(e -> e.substring(0, e.lastIndexOf("/") + 1));
    public final String USERNAME = PropertiesFileHelper.getByKey("spring.datasource.username").orElse(null);
    public final String PASSWORD = PropertiesFileHelper.getByKey("spring.datasource.password").orElse(null);

    @Getter
    private Connection serverConnection;

    @Getter
    private Connection dbConnection;

    static {
        if (CommandPropertiesProcessor.ENABLED)
            ThreadHelper.sleep(1000);
        setServerConnection();
        setDbConnection();
    }

    public Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            log.error(exception.getLocalizedMessage() + ". SQL State: {}", exception.getSQLState());
            return null;
        }
    }

    public boolean testConnection(String url, Consumer<SQLException> onCatch) {
        try (Connection ignored = DriverManager.getConnection(url, USERNAME, PASSWORD)) {
            return true;
        } catch (SQLException exception) {
            if (onCatch != null) onCatch.accept(exception);
            return false;
        }
    }

    public void setServerConnection() {
        serverConnection = getConnection(SERVER_URL);
    }

    public void setDbConnection() {
        dbConnection = getConnection(DB_URL);
    }

    @SneakyThrows(SQLException.class)
    public Optional<String> getDbProductName() {
        if (serverConnection == null) {
            if (DB_URL.matches("jdbc:.*:.*"))
                return Optional.of(DB_URL.transform(url -> url.substring(6, url.indexOf(':', 6))));
            return Optional.empty();
        }
        return Optional.of(serverConnection.getMetaData().getDatabaseProductName());
    }

}
