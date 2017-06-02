package ru.job4j.generic;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 30.05.2017.
 */
public class SimpleArrayTest {

    /**
     * Test add. Type String.
     */
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        final int size = 2;
        SimpleArray<String> simpleArray = new SimpleArray<>(size);

        simpleArray.add("first");
        simpleArray.add("second");

        Assert.assertThat(simpleArray.get(0), Is.is("first"));
        Assert.assertThat(simpleArray.get(1), Is.is("second"));
    }

    /**
     * Test add. Type Integer.
     */
    @Test
    public void whenTypeIntShouldReturnInt() {
        final int size = 1;
        SimpleArray<Integer> simpleArray = new SimpleArray<>(size);

        simpleArray.add(1);

        Assert.assertThat(simpleArray.get(0), Is.is(1));
    }

    /**
     * Test update. Type String.
     */
    @Test
    public void whenUpdateElement() {
        final int size = 1;
        SimpleArray<String> simpleArray = new SimpleArray<>(size);

        simpleArray.add("test");
        simpleArray.update(0, "update");

        Assert.assertThat(simpleArray.get(0), Is.is("update"));
    }

    /**
     * Test delete. Type String.
     */
    @Test
    public void whenDeleteElement() {
        final int size = 4;
        SimpleArray<String> simpleArray = new SimpleArray<>(size);

        simpleArray.add("test0");
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");

        simpleArray.delete(1);

        String[] expect = {"test0", "test2", "test3", null};

        for (int i = 0; i < size; i++) {
            Assert.assertThat(simpleArray.get(i), Is.is(expect[i]));
        }
    }
}


/**
 * Job4j / Courses / Junior / Задания / 2. Пакет. Стандарт. / Часть 005. Collections. Pro. / 2. Generic /.
 */
class Examples {
    /**
     * Example. Принимает и возвращает объект. Выводит его в консоль.
     * @param value - объект.
     * @param <K> - тип объекта.
     * @return - объект.
     */
    private <K> K print(K value) {
        System.out.println(value);
        return value;
    }


    /**
     * Example. Метод может принимать аргументы типа Set и все наследованные от него.
     * @param list - объект.
     */
    private void printUpper(SimpleArray<? extends Set> list) {
    }

    /**
     * Example. Метод может принимать аргументы типа Set и все родительские объекты.
     * @param list - объект.
     */
    private void printLower(SimpleArray<? super Set> list) {
    }

    /**
     * В данном примере показано какие объекты можно использовать в generic.
     * 1. Наследованный объект HashSet от Set.
     * 2. Родительский объект Collection для Set.
     */
    private void aVoid() {
        // использование наследованного объекта от Set.
        this.printUpper(new SimpleArray<HashSet>(0));

        // использование родительского объекта Set.
        this.printLower(new SimpleArray<Collection>(0));
    }
}
