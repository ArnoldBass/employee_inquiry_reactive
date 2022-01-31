package com.learn.employeeinquiry.dao;

import com.learn.employeeinquiry.exception.EmployeeNotFound;
import com.learn.employeeinquiry.model.Employee;
import com.learn.employeeinquiry.model.Salary;
import com.learn.employeeinquiry.model.Title;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Component
public class EmployeeDao {
    @Autowired
    ConnectionFactory connectionFactory;
    R2dbcEntityTemplate template;

    @PostConstruct
    void init(){
        template = new R2dbcEntityTemplate(connectionFactory);
    }

    public Flux<Employee> findEmployeeById(String id){
        return template.select(query(where("id").is(id)),Employee.class);
    }

    public Flux<Salary> findSalaryByEmployeeId(String id){
        return template.select(query(where("employee_id").is(id)),Salary.class);
    }

    public Flux<Title> findTitleByEmployeeId(String id){
        return template.select(query(where("employee_id").is(id)),Title.class);
    }
}
