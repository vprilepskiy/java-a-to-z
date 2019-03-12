package ru.prilepskiy.service;

import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.repository.BodyTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
