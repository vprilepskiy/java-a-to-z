package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

    RoleEntity findByAuthority(String authority);

}
