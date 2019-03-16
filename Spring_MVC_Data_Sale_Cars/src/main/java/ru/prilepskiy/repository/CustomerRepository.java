package ru.prilepskiy.repository;

import ru.prilepskiy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
