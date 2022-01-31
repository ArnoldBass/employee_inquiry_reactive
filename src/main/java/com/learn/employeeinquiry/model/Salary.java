package com.learn.employeeinquiry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salary {
    @JsonIgnore
    Integer employee_id;
    Integer amount;
    Date from_date;
    Date to_date;
}
