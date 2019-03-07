package com.devcolibri.dataexam.repository;

import com.devcolibri.dataexam.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long> {

    @Override
    Iterable<Bank> findAll();
}
