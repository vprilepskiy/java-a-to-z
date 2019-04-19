package pools;

/**
 * Пул - это хранилища для ресурсов, которые можно переиспользовать.
 *
 * Клиент берет ресурс из пула, выполняет свою работу и возвращается обратно в пул.
 *
 * Общая схема реализации пула.
 *
 *
 *
 * 1. Инициализация пула должна быть по количеству ядер в системе.
 *
 * int size = Runtime.getRuntime().availableProcessors()
 *
 * В каждую нить передается блокирующая очередь tasks.
 *
 * Количество нитей всегда одинаковое и равно size.
 *
 * В методе run мы должны получить задачу их очереди tasks.
 *
 * tasks - это блокирующая очередь. Если в очереди нет элементов, то нить переводиться в состоянии waiting.
 *
 * Когда приходит новая задача, всем нитям в состоянии waiting посылается сигнал проснуться и начать работу.
 *
 * 2. Создать метод work(Runnable job). - этот метод должен добавлять задачи в блокирующую очередь tasks.
 * Каркас пула.
 *
 * package ru.job4j.pool;
 *
 * import java.util.LinkedList;
 * import java.util.List;
 * import java.util.Queue;
 * import java.util.concurrent.LinkedBlockingQueue;
 *
 * public class ThreadPool {
 *     private final List<Thread> threads = new LinkedList<>();
 *     private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
 *
 *     public void work(Runnable job) {
 *
 *     }
 *
 *     public void shutdown() {
 *
 *     }
 * }
 *
 * SimpleBlockingQueue - Это класс из задачи  1. Реализовать шаблон Producer Consumer. [#1098]
 */