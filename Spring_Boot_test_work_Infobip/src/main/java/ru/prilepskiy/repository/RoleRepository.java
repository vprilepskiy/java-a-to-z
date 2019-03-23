package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.RoleEntity;


/**
 * Created by VLADIMIR on 11.04.2018.
 */
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

    RoleEntity findByAuthority(String authority);

}
