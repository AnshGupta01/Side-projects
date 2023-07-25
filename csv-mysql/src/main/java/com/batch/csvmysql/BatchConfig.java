package com.batch.csvmysql;

import com.batch.csvmysql.Entity.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public FlatFileItemReader<Employee> reader(){
        return new FlatFileItemReaderBuilder<Employee>().name("Employee_builder")
                .resource(new ClassPathResource("records.csv"))
                .delimited()
                .names(new String[] {"Organization Id",
                        "Name","Website","Country","Founded","Number of employees"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>(){{
                    setTargetType(Employee.class);
                }})
                .build();

//        FlatFileItemReader<com.batch.csvmysql.Entity.Employee> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("records.csv"));
//        reader.setLineMapper(getLineMapper());
//        reader.setLinesToSkip(1);
//        return reader;
    }

//    private LineMapper<com.batch.csvmysql.Entity.Employee> getLineMapper() {
//        DefaultLineMapper<com.batch.csvmysql.Entity.Employee> lineMapper = new DefaultLineMapper<>();
//
//        DelimitedLineTokenizer lineToken = new DelimitedLineTokenizer();
//
//        lineToken.setNames("Organization Id",
//                "Name","Website","Country","Founded","Number of employees");
//
//        lineToken.setIncludedFields(1,2,3,4,6,8);
//
//        BeanWrapperFieldSetMapper<com.batch.csvmysql.Entity.Employee> fieldSetter = new BeanWrapperFieldSetMapper<>();
//        fieldSetter.setTargetType(com.batch.csvmysql.Entity.Employee.class);
//
//        lineMapper.setLineTokenizer(lineToken);
//        lineMapper.setFieldSetMapper(fieldSetter);
//
//        return lineMapper;
//
//    }
    @Bean
    public EmpItemProcessor processor(){
        return new EmpItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Employee> writer(){
        JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider
                (new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("insert into employee(organisation_id, name, website,country, founded_date,no_of_emp) values (:organisation_id, :name, :website,country, :founded_date, :no_of_emp)");

        writer.setDataSource(this.dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(){
        return new JobBuilder("USER_IMPORT_JOB", jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end().build();
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Employee,Employee>chunk(10,transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
