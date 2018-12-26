package com.yfy.beem.serverv2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Class that configures the datasource needed
 * */
@Configuration
public class DatasourceConfiguration {
    private final Environment env;

    @Autowired
    public DatasourceConfiguration(Environment env) {
        this.env = env;
    }

    /**
     * Used to configure a {@link DataSource} from fields that will later be taken from environment.
     * */
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username("teppahdb")
                .password("7619438520")
                .url("jdbc:postgresql://users.c1lsjbxaghz1.ca-central-1.rds.amazonaws.com:5432/users")
                .driverClassName("org.postgresql.Driver")
                .build();

    }
}
