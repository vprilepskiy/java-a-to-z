package com.devcolibri.dataexam.controller;

import com.devcolibri.dataexam.entity.Bank;
import com.devcolibri.dataexam.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/a")
    public Iterable<Bank> getBank() {
        return this.bankService.findAll();
    }

}
