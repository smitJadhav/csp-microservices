package com.csp.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Component
@ConfigurationProperties(prefix = "database")
@Getter
@Setter
public class DatabaseConfig {

    private String url;
    private String username;
    private String password;
    private String[] packagesToScan;
    private hikariProperties hikariProperties;

    public HikariDataSource createDataSource() throws Exception {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setAutoCommit(hikariProperties.autoCommit);
        config.setPoolName(hikariProperties.poolName);
        config.setMaximumPoolSize(hikariProperties.maxPoolSize);
        config.setIdleTimeout(hikariProperties.maxIdleTime);
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }


    @Getter
    @Setter
    public static class hikariProperties {
        private Boolean autoCommit;
        private String poolName;
        private Integer maxPoolSize;
        private Long maxIdleTime;
    }

}
