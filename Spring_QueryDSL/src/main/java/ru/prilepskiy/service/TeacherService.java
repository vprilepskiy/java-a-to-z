package ru.prilepskiy.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.mapper.ObjectMapper;
import ru.prilepskiy.model.QTeacherEntity;
import ru.prilepskiy.model.SchoolClassEntity;
import ru.prilepskiy.model.TeacherEntity;
import ru.prilepskiy.repository.TeacherRepository;
import ru.prilepskiy.repository.specification.TeacherRepositorySpec;
import ru.prilepskiy.repository.specification.TeacherSpecification;
import ru.prilepskiy.search.TeacherSearchCriteria;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherRepositorySpec repositorySpec;
    private final ObjectMapper mapper;

    public TeacherService(TeacherRepository repository, TeacherRepositorySpec repositorySpec, ObjectMapper mapper) {
        this.repository = repository;
        this.repositorySpec = repositorySpec;
        this.mapper = mapper;
    }

    public TeacherEntity findById(int id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Set<TeacherDto> find(TeacherSearchCriteria criteria) {
        final BooleanBuilder where = new BooleanBuilder();

        Optional.ofNullable(criteria.getSchoolId())
            .ifPresent(id -> where.and(QTeacherEntity.teacherEntity.classes.any().school.id.eq(id)));

        Optional.ofNullable(criteria.getClassId()).ifPresent(id -> {
            final SchoolClassEntity v = new SchoolClassEntity();
            v.setId(id);
            where.and(QTeacherEntity.teacherEntity.classes.contains(v));
        });

        Optional.ofNullable(criteria.getTeacherFirstName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.firstName.contains(v)));

        Optional.ofNullable(criteria.getTeacherMiddleName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.middleName.contains(v)));

        Optional.ofNullable(criteria.getTeacherLastName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.lastName.contains(v)));

        Optional.ofNullable(criteria.getStudentFirstName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().firstName.contains(v)));

        Optional.ofNullable(criteria.getStudentMiddleName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().middleName.contains(v)));

        Optional.ofNullable(criteria.getStudentLastName())
            .ifPresent(v -> where.and(QTeacherEntity.teacherEntity.classes.any().students.any().lastName.contains(v)));

        Iterable<TeacherEntity> entities = this.repository.findAll(where);
        return StreamSupport.stream(entities.spliterator(), false).map(mapper::toDto).collect(Collectors.toSet());
    }

    public List<TeacherEntity> findSpec(TeacherSearchCriteria criteria) {
        Specification<TeacherEntity> teacherEntitySpecification = TeacherSpecification.byCriteria(criteria);
        return this.repositorySpec.findAll(Specification.where(teacherEntitySpecification));
    }
}
