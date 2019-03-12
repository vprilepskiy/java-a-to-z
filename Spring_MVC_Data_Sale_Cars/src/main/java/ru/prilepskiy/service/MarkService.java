package ru.prilepskiy.service;

import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MarkService {

    @Autowired
    MarksRepository marksRepository;

    public Iterable<MarksEntity> getMarks() {
        return this.marksRepository.findAll();
    }

}
