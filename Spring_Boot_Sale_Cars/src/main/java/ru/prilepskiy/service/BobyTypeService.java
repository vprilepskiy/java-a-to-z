package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.repository.BodyTypesRepository;

@Service
@Transactional
public class BobyTypeService {

    @Autowired
    BodyTypesRepository bodyTypesRepository;

    /**
     * Get body types.
     * @return - bodyTypes.
     */
    public Iterable<BodyTypesEntity> getBodyTapes() {
        return this.bodyTypesRepository.findAll();
    }

}
