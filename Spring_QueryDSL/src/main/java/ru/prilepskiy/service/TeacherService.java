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
import java.util.Set;
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

        if (criteria.getSchoolId() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().school.id.eq(criteria.getSchoolId()));
        }

        if (criteria.getClassId() != null) {
            final SchoolClassEntity schoolClassEntity = new SchoolClassEntity();
            schoolClassEntity.setId(criteria.getClassId());
            where.and(QTeacherEntity.teacherEntity.classes.contains(schoolClassEntity));
        }

        if (criteria.getTeacherFirstName() != null) {
            where.and(QTeacherEntity.teacherEntity.firstName.contains(criteria.getTeacherFirstName()));
        }

        if (criteria.getTeacherMiddleName() != null) {
            where.and(QTeacherEntity.teacherEntity.middleName.contains(criteria.getTeacherFirstName()));
        }

        if (criteria.getTeacherLastName() != null) {
            where.and(QTeacherEntity.teacherEntity.lastName.contains(criteria.getTeacherLastName()));
        }

        if (criteria.getStudentFirstName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().firstName.contains(criteria.getStudentFirstName()));
        }

        if (criteria.getStudentMiddleName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().middleName.contains(criteria.getStudentMiddleName()));
        }

        if (criteria.getStudentLastName() != null) {
            where.and(QTeacherEntity.teacherEntity.classes.any().students.any().lastName.contains(criteria.getStudentLastName()));
        }

        Iterable<TeacherEntity> entities = this.repository.findAll(where);
        return StreamSupport.stream(entities.spliterator(), false).map(t -> mapper.toDto(t)).collect(Collectors.toSet());
    }

    public List<TeacherEntity> findSpec(TeacherSearchCriteria criteria) {
        Specification<TeacherEntity> teacherEntitySpecification = TeacherSpecification.byCriteria(criteria);
        return this.repositorySpec.findAll(Specification.where(teacherEntitySpecification));
    }
}
