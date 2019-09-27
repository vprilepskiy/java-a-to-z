package ru.prilepskiy.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.prilepskiy.entity.User;

public interface UserRepository extends ElasticsearchRepository<User, String> {

}
