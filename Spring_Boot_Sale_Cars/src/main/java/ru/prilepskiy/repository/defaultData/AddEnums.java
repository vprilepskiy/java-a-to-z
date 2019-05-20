package ru.prilepskiy.repository.defaultData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.repository.BodyTypesRepository;
import ru.prilepskiy.repository.MarksRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddEnums {

    @Autowired
    BodyTypesRepository bodyTypesRepository;

    @Autowired
    MarksRepository marksRepository;

    @Bean
    public Iterable<BodyTypesEntity> bodyTypes() {
        if (this.bodyTypesRepository.count() == 0) {
            final Set<BodyTypesEntity> bodyTypes = Arrays.stream(BodyTypes.values()).map(bt -> bt.getBodyType()).collect(Collectors.toSet());
            return this.bodyTypesRepository.saveAll(bodyTypes);
        }
        return null;
    }

    @Bean
    public Iterable<MarksEntity> marks() {
        if (this.marksRepository.count() == 0) {
            final Set<MarksEntity> marks = Arrays.stream(Marks.values()).map(bt -> bt.getMark()).collect(Collectors.toSet());
            return marksRepository.saveAll(marks);
        }
        return null;
    }
}
