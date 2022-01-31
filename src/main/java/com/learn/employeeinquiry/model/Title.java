package com.learn.employeeinquiry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    @JsonIgnore
    Integer employee_id;
    String title;
    Date from_date;
    Date to_date;
}
