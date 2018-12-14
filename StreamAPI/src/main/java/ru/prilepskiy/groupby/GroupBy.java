package ru.prilepskiy.groupby;

import ru.prilepskiy.groupby.molel.Speciality;
import ru.prilepskiy.groupby.molel.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alex", Speciality.Physics, 1),
            new Student("Rika", Speciality.Biology, 4),
            new Student("Julia", Speciality.Biology, 2),
            new Student("Steve", Speciality.History, 4),
            new Student("Mike", Speciality.Finance, 1),
            new Student("Hinata", Speciality.Biology, 2),
            new Student("Richard", Speciality.History, 1),
            new Student("Kate", Speciality.Psychology, 2),
            new Student("Sergey", Speciality.ComputerScience, 4),
            new Student("Maximilian", Speciality.ComputerScience, 3),
            new Student("Tim", Speciality.ComputerScience, 5),
            new Student("Ann", Speciality.Psychology, 1)
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
    }
}
