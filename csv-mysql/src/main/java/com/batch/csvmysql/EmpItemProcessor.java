package com.batch.csvmysql;

import com.batch.csvmysql.Entity.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmpItemProcessor implements ItemProcessor<Employee, Employee> {

    @Override
    public Employee process(Employee employee) throws Exception {
        return employee;
    }
}
