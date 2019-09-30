package ru.prilepskiy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import ru.prilepskiy.model.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface QueryDslRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
