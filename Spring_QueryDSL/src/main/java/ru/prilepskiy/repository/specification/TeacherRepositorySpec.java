package ru.prilepskiy.repository.specification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.prilepskiy.model.TeacherEntity;

public interface TeacherRepositorySpec extends JpaRepository<TeacherEntity, Integer>, JpaSpecificationExecutor<TeacherEntity> {

}
