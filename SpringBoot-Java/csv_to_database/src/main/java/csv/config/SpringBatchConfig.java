package csv.config;

import csv.Entities.Customers;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import csv.repository.CustomerRepo;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringBatchConfig {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private JobRepository jobRepository;

    @Bean
    public FlatFileItemReader<Customers> reader() {
        FlatFileItemReader<Customers> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("customers.csv"));
        reader.setLineMapper(getLineMapper());
        reader.setLinesToSkip(1);
        return reader;
    }

    private LineMapper<Customers> getLineMapper() {
        DefaultLineMapper<Customers> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineToken = new DelimitedLineTokenizer();

        lineToken.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        lineToken.setIncludedFields(0,1,2,3,4,5,6,7);

        BeanWrapperFieldSetMapper<Customers> fieldSetter = new BeanWrapperFieldSetMapper<>();
        fieldSetter.setTargetType(Customers.class);

        lineMapper.setLineTokenizer(lineToken);
        lineMapper.setFieldSetMapper(fieldSetter);

        return lineMapper;
    }
//        return new FlatFileItemReaderBuilder<Customers>().name("Employee_builder")
//                .resource(new ClassPathResource("customers.csv"))
//                .lineTokenizer(new DelimitedLineTokenizer()
//                {{setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");}})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
//                    setTargetType(Customers.class);
//                }})
//                .build();


    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customers> writer() {
        RepositoryItemWriter<Customers> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1() {
        return new StepBuilder("csv-step", jobRepository)
                .<Customers, Customers>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("Customers", jobRepository)
                .start(step1())
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
