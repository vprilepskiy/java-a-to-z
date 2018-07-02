package ru.prilepskiy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.prilepskiy.domain.User;

/**
 * Created by VLADIMIR on 09.04.2018.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    UserDetails findByUsername(String username);

    @Procedure(name = "sys_guid")
    String getGuId();
}
