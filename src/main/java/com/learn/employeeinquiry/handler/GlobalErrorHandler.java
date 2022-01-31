package com.learn.employeeinquiry.handler;

import com.learn.employeeinquiry.exception.EmployeeNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error("Exception message is {}", ex.getMessage(), ex);
        DataBufferFactory dataBufferFactory = exchange.getResponse().bufferFactory();
        var errorMsg = dataBufferFactory.wrap(ex.getMessage().getBytes(StandardCharsets.UTF_8));
         if(ex instanceof EmployeeNotFound){
             exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
             return exchange.getResponse().writeWith(Mono.just(errorMsg));
         }
        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return exchange.getResponse().writeWith(Mono.just(errorMsg));
    }
}
