package csv.config;

import csv.Entities.Customers;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customers,Customers> {

    @Override
    public Customers process(Customers customers) throws Exception {
        return customers;
    }
}
