package com.learn.employeeinquiry.handler;

import com.learn.employeeinquiry.dao.EmployeeDao;
import com.learn.employeeinquiry.exception.EmployeeNotFound;
import com.learn.employeeinquiry.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {
    EmployeeDao dao;

    @Autowired
    public EmployeeHandler(EmployeeDao dao) {
        this.dao = dao;
    }

    /**
     * Finds an employee by an ID
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findEmployee(ServerRequest serverRequest) {
        //Path Variable is id
        String id = serverRequest.pathVariable("id");

        //if employee is empty throw not found.
        var empResults= dao.findEmployeeById(id)
                .filter(employee -> employee.getId()!=null)
                .switchIfEmpty(Flux.error(new EmployeeNotFound("Employee does not exist")));
        var titleResult = dao.findTitleByEmployeeId(id);
        var salaryResult = dao.findSalaryByEmployeeId(id);

        EmployeeResponse.EmployeeResponseBuilder builder= EmployeeResponse.builder();
        var zipped= Flux.zip(empResults,salaryResult,titleResult)
                .map(tuple -> {
                     return builder.employee(tuple.getT1())
                             .salary(tuple.getT2())
                             .title(tuple.getT3())
                             .build();

                });
        return ServerResponse.ok().body(zipped,EmployeeResponse.class);
    }
}
