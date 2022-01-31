package com.learn.employeeinquiry.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class R2dbcConfigs {

    @Bean
    ConnectionFactory connectionFactory(){
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(Option.valueOf("driver"),"postgresql")
                .option(Option.valueOf("host"),"localhost")
                .option(Option.valueOf("port"),5432)
                .option(Option.valueOf("user"),"postgres")
                .option(Option.valueOf("password"),"jedi")
                .option(Option.valueOf("database"),"employees_database")
                .option(Option.valueOf("schema"),"employees")
                .build();

        return ConnectionFactories.get(options);
    }
}
