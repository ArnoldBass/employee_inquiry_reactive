package com.learn.employeeinquiry.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    Integer id;
    Date birth_date;
    String first_name;
    String last_name;
    String gender;
    Date hire_date;
}
