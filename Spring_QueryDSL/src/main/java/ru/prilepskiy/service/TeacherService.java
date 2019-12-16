package ru.prilepskiy.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.dto.search.TeacherSearchCriteria;
import ru.prilepskiy.mapper.ObjectMapper;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.repository.TeacherRepository;
import ru.prilepskiy.service.search.CriteriaHelper;
import ru.prilepskiy.service.search.TeacherSpecification;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TeacherService {

    private final TeacherRepository repository;
    private final ObjectMapper mapper;

    public TeacherService(TeacherRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TeacherEntity findById(int id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Set<TeacherDto> findTeacherByQueryDsl(TeacherSearchCriteria criteria) {
        Predicate predicate = CriteriaHelper.toPredicate(criteria);
        Iterable<TeacherEntity> entities = this.repository.findAll(predicate);
        return StreamSupport.stream(entities.spliterator(), false).map(mapper::toDto).collect(Collectors.toSet());
    }

    public Set<TeacherDto> findTeacherBySpecification(TeacherSearchCriteria criteria) {
        Specification<TeacherEntity> teacherEntitySpecification = TeacherSpecification.byCriteria(criteria);
        List<TeacherEntity> entities = this.repository.findAll(teacherEntitySpecification);
        return entities.stream().map(mapper::toDto).collect(Collectors.toSet());
    }
}
