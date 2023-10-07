package csv.repository;

import csv.Entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepo extends JpaRepository<Customers, Integer> {
}
