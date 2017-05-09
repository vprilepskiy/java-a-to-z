/**
 * Created by VLADIMIR on 08.05.2017.
 *
 * 1. Организовать сортировку User
 *
 * Необходимо создать модель User с полями name, age.
 * Класс User должен реализовать интерфейс Comparable.
 * В классе ISortUser написать метод public Set<User> sort (List<User>),
 * который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
 *
 * 2. Сортировка User с использованием Comparator [#14425]
 *
 * В классе SortUser из 1-го задания необходимо написать два метода:
 * public List<User> sortHash (List<User>) - в этом методе необходимо определить Comparator для метода Collections.sort и отсортировать List<User> по hash-коду.
 * public List<User> sortLength (List<User>) - в этом методе необходимо определить Comparator для метода Collections.sort и отсортировать List<User> по длине имени.
 */
package ru.job4j.sorting;