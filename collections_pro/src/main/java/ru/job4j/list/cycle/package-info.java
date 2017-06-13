/**
 * Created by VLADIMIR on 08.06.2017.
 *
 * 5.3.4. Задан связанный список. Определить цикличность. [#16253]
 *
 *    Задан связанный список.
 *
 *    class Node<T> {
 *       T value;
 *       Node<T> next;
 *    }
 *
 *  Node first = new Node(1);
 *  Node two = new Node(2);
 *  Node third = new Node(3);
 *  Node four = new Node(4);
 *
 *  first.next = two;
 *  two.next = third;
 *  third.next = four;
 *  four.next = first;
 *
 *  Написать алгоритм определяющий, что список содержит замыкания.
 *
 *  boolean hasCycle(Node first);
 */
package ru.job4j.list.cycle;