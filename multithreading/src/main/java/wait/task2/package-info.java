package wait.task2;
/*
*
* 2. Обеспечить остановку потребителя. [#66825]
  Петр Арсентьев,  17.08.18 13:31
В этом задании нужно разработать механизм остановки потребителя, когда производитель закончил свою работу.

Представим утилиту по поиску текста в файловой системе.

Одна нить ищет файлы с подходящим именем. Вторая нить берет эти файлы и читает.

Это схема хорошо описывается шаблон Producer Consumer. Однако есть один момент.

Когда первая нить заканчивает свою работу, потребители переходят в режим wait.

И утилита работает вечно.

Давайте составим упрощенный код такой программы.

package ru.job4j.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();
    }
}

Если мы запустим этот код. то на консоли мы увидим. что нить производитель закончила работу, а нить потребитель продолжает ждать событий.
Ваша задача изменить код, так. что бы потребитель завершал свою работу.
Код нужно изменить в методе main.
*/