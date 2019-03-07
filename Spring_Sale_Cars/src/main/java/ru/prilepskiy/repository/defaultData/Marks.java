package ru.prilepskiy.repository.defaultData;


import ru.prilepskiy.domain.MarksEntity;
import ru.prilepskiy.domain.ModelsEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by VLADIMIR on 12.03.2018.
 */
public enum Marks {

    AUDI (Arrays.asList("A3", "A4", "Q5", "Q7")),
    VOLKSWAGEN (Arrays.asList("PASSAT", "TIGUAN", "TOUAREG")),
    SEAT (Arrays.asList("Ibiza", "Leon", "Altea", "Altea freetrack"));

    private MarksEntity mark;

    Marks(List<String> modelList) {
        MarksEntity mark = new MarksEntity(this.name());
        Set<ModelsEntity> modelSet = new HashSet<>();
        for (String modelName : modelList) {
            modelSet.add(new ModelsEntity(modelName));
        }
        mark.setModels(modelSet);
        this.mark = mark;
    }

    public MarksEntity getMark() {
        return this.mark;
    }
}
