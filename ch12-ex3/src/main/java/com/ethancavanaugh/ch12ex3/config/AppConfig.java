package com.ethancavanaugh.ch12ex3.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class AppConfig {
    @Value("${custom.datasource.url}")
    private String datasourceURL;
    @Value("${custom.datasource.username}")
    private String datasourceUsername;
    @Value("${custom.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource customMySQLDatasource(){
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(datasourceURL);
        ds.setUsername(datasourceUsername);
        ds.setPassword(datasourcePassword);
        ds.setConnectionTimeout(1000);

        return ds;
    }
}
