package ru.prilepskiy.repository;

import ru.prilepskiy.model.BaseEntity;

import java.io.Serializable;

public interface SimpleJpaRepository<T extends BaseEntity, ID extends Serializable> extends org.springframework.data.jpa.repository.JpaRepository<T, ID> {
}
