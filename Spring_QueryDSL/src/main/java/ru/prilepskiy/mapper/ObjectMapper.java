package ru.prilepskiy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.prilepskiy.dto.SchoolDto;
import ru.prilepskiy.dto.TeacherDto;
import ru.prilepskiy.model.SchoolClassEntity;
import ru.prilepskiy.model.SchoolEntity;
import ru.prilepskiy.model.StudentEntity;
import ru.prilepskiy.model.TeacherEntity;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface ObjectMapper {

    SchoolDto toDto(SchoolEntity entity);

    @Mapping(target = "numberStudents", source = "classes", qualifiedByName = "numberStudentsFromClasses")
    @Mapping(target = "school", source = "classes", qualifiedByName = "schoolFromClasses")
    TeacherDto toDto(TeacherEntity entity);

    @Named("numberStudentsFromClasses")
    default Integer numberStudentsFromClasses(Set<SchoolClassEntity> classes) {
        final Set<StudentEntity> students = new HashSet<>();
        classes.forEach(c -> students.addAll(c.getStudents()));
        return students.size();
    }

    @Named("schoolFromClasses")
    default SchoolDto schoolFromClasses(Set<SchoolClassEntity> classes) {
        return toDto(classes.iterator().next().getSchool());
    }
}
