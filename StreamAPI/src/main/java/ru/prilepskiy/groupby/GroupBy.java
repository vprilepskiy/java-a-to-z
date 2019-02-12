package ru.prilepskiy.groupby;

import ru.prilepskiy.groupby.molel.Speciality;
import ru.prilepskiy.groupby.molel.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupBy {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alex", Speciality.Physics, 1, Boolean.TRUE),
            new Student("Rika", Speciality.Biology, 4, null),
            new Student("Julia", Speciality.Biology, 2, Boolean.FALSE),
            new Student("Steve", Speciality.History, 4, Boolean.TRUE),
            new Student("Mike", Speciality.Finance, 1, null),
            new Student("Hinata", Speciality.Biology, 2, Boolean.TRUE),
            new Student("Richard", Speciality.History, 1, Boolean.FALSE),
            new Student("Kate", Speciality.Psychology, 2, Boolean.TRUE),
            new Student("Sergey", Speciality.ComputerScience, 4, Boolean.TRUE),
            new Student("Maximilian", Speciality.ComputerScience, 3, Boolean.TRUE),
            new Student("Tim", Speciality.ComputerScience, 5, Boolean.TRUE),
            new Student("Ann", Speciality.Psychology, 1, Boolean.TRUE)
        );

        Map<Speciality, List<Student>> map3 = students.stream().collect(Collectors.groupingBy(Student::getSpeciality));

        map3.forEach((S, L) -> System.out.println(S + " " + L.size()));
        // Finance 1
        // Psychology 2
        // History 2
        // Biology 3
        // Physics 1
        // ComputerScience 3

        System.out.println("----------------------------------");

        map3.forEach((S, L) -> System.out.println(S + " " + L));
        // Finance [Student{name='Mike', speciality=Finance, year=1}]
        // Psychology [Student{name='Kate', speciality=Psychology, year=2}, Student{name='Ann', speciality=Psychology, year=1}]
        // History [Student{name='Steve', speciality=History, year=4}, Student{name='Richard', speciality=History, year=1}]
        // Biology [Student{name='Rika', speciality=Biology, year=4}, Student{name='Julia', speciality=Biology, year=2}, Student{name='Hinata', speciality=Biology, year=2}]
        // Physics [Student{name='Alex', speciality=Physics, year=1}]
        // ComputerScience [Student{name='Sergey', speciality=ComputerScience, year=4}, Student{name='Maximilian', speciality=ComputerScience, year=3}, Student{name='Tim', speciality=ComputerScience, year=5}]

        System.out.println("----------------------------------");

        Map<Speciality, Optional<Student>> optionalMap = students.stream().collect(Collectors.groupingBy(Student::getSpeciality, Collectors.maxBy(Comparator.comparing(Student::getYear))));
        List<Student> collect = optionalMap.values().stream().map(student -> student.get()).collect(Collectors.toList());
        System.out.println(collect);

        optionalMap.forEach((S, L) -> System.out.println(S + " " + L));

        System.out.println("----------------------------------");
        students.sort(Comparator.comparing(Student::getActive, Comparator.nullsFirst(Boolean::compareTo)).thenComparing(Student::getName));
//        students.sort(Comparator.comparing(Student::getActive, (o1, o2) -> (Optional.ofNullable(o1).orElse(Boolean.FALSE).compareTo(Optional.ofNullable(o2).orElse(Boolean.FALSE)))).thenComparing(Student::getYear));
        students.forEach(student -> System.out.println(student));

        System.out.println("----------------------------------");

        Map<Speciality, Optional<Student>> optionalMap1 = students.stream().collect(Collectors.groupingBy(Student::getSpeciality, Collectors.maxBy(Comparator.comparing(Student::getActive, (o1, o2) -> (Optional.ofNullable(o1).orElse(Boolean.FALSE).compareTo(Optional.ofNullable(o2).orElse(Boolean.FALSE)))).thenComparing(Student::getYear))));
        List<Student> collect1 = optionalMap1.values().stream().map(student -> student.get()).collect(Collectors.toList());
        System.out.println(collect1);

        optionalMap.forEach((S, L) -> System.out.println(S + " " + L));

    }
}
