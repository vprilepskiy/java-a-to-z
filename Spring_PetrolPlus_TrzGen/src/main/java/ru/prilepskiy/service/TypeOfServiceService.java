package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.TypeOfService;
import ru.prilepskiy.repository.TypeOfServiceRepository;

/**
 * Все виды топлива.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Service
public class TypeOfServiceService {

    @Autowired
    TypeOfServiceRepository typeOfServiceRepository;

    /**
     * Верент все виды топлива.
     * @return
     */
    public Iterable<TypeOfService> getAll() {
        return this.typeOfServiceRepository.findAll();
    }

}
