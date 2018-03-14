package ru.job4j.model.store.defaultData;

import ru.job4j.model.entity.Mark;
import ru.job4j.model.entity.Model;

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


    private Mark mark;


    Marks(List<String> modelList) {
        Mark mark = new Mark(this.name());
        Set<Model> modelSet = new HashSet<>();
        for (String modelName : modelList) {
            modelSet.add(new Model(modelName, mark));
        }
        mark.setModels(modelSet);
        this.mark = mark;
    }


    public Mark getMark() {
        return this.mark;
    }
}
