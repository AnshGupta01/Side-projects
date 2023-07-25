package com.batch.csvmysql.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String organisation_id;
    private String name;
    private String website;
    private String country;
    private Integer founded_date;
    private Integer no_of_emp;
}
