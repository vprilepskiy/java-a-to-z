package ru.job4j.iterator.convert;

import java.util.Iterator;

/**
 * Job4j / Courses / Junior / Ученики / Vladimir Prilepskiy / 2. Пакет. Стандарт. / Часть 005. Collections. Pro. / 1. MyItrator /
 *  5.1.4. Создать convert(MyIterator<MyIterator>) [#15309]
 *
 * Реализовать интерфейс с методом MyIterator<Integer> convert(MyIterator<MyIterator<Integer>> it).
 *  Что из себя представляет запись MyIterator<MyIterator<Integer>?.
 *  Каждый итератор это последовательность.
 *  Итератор 1 – 4 2 0 4 6 4 9
 *  Итератор 2 – 0 9 8 7 5
 *  Итератор 3 – 1 3 5 6 7 0 9 8 4
 *  Если мы говорим о записи Итератор Итераторов. Значит итератор содержит не конечные значения, а сложенные итераторы.
 *  Итератор - Итератор 1, Итератор 2, Итератор 3.
 *  Метод convert должен принимать объект итератор итератор и возвращать Итератор чисел.
 *  MyIterator<MyIterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4))
 *
 *  Метод должен возвращать
 * MyItrator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4)
 *  Метод не должен копировать данные. Нужно реализовать итератор, который будет пробегать по вложенными итераторам без копирования данных.
 *
 * Created by VLADIMIR on 27.05.2017.
 */
public interface IConverter {

    /**
     * Конвертирует двойной итрератор в одинарный.
     * @param it - двойной итератор.
     * @return - одинарный итератор.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
