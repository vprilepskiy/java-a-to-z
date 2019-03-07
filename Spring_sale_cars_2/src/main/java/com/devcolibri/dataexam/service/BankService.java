package com.devcolibri.dataexam.service;

import com.devcolibri.dataexam.entity.Bank;
import com.devcolibri.dataexam.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public Iterable<Bank> findAll() {
        return this.bankRepository.findAll();
    }

}
