package com.learn.employeeinquiry.router;

import com.learn.employeeinquiry.handler.EmployeeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(EmployeeHandler employeeHandler){
        return RouterFunctions.route().GET("/v1/employee/{id}",employeeHandler::findEmployee).build();
    }
}
