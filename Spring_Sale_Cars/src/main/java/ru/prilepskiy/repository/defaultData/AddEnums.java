package ru.prilepskiy.repository.defaultData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.BodyTypesEntity;
import ru.prilepskiy.domain.MarksEntity;
import ru.prilepskiy.repository.BodyTypesRepository;
import ru.prilepskiy.repository.MarksRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Добавить в БД новые сущности.
 *
 * Created by VLADIMIR on 07.03.2019.
 */
@Service
public class AddEnums {

    @Autowired
    BodyTypesRepository bodyTypesRepository;

    @Autowired
    MarksRepository marksRepository;

    @Bean
    public Iterable<BodyTypesEntity> bodyTypes() {
        System.out.println("*************1");
        final Set<BodyTypesEntity> bodyTypes = Arrays.stream(BodyTypes.values()).map(bt -> bt.getBodyType()).collect(Collectors.toSet());
        return this.bodyTypesRepository.save(bodyTypes);
    }

    @Bean
    public Iterable<MarksEntity> marks() {
        System.out.println("*************2");
        final Set<MarksEntity> marks = Arrays.stream(Marks.values()).map(bt -> bt.getMark()).collect(Collectors.toSet());
        return marksRepository.save(marks);
    }
}
