package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Role;

/**
 * Created by VLADIMIR on 11.04.2018.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByAuthority(String authority);

}
