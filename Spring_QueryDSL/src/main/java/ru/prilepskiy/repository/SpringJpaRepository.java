package ru.prilepskiy.repository;

import org.springframework.stereotype.Repository;
import ru.prilepskiy.model.BaseEntity;

import java.io.Serializable;

@Repository
public interface SpringJpaRepository<T extends BaseEntity, ID extends Serializable> extends org.springframework.data.jpa.repository.JpaRepository<T, ID> {
}
