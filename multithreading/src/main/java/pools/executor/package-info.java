package pools.executor;

/**
 * 2. ExecutorService рассылка почты. [#63097]
 *   Петр Арсентьев,  30.12.18 16:34
 * В предыдущем задании мы познакомились, как в примитивном случае можно реализовать пул нитей.
 *
 * В JDK входит пакет concurrent в котором уже есть готовая реализация.
 *
 * import java.util.concurrent.ExecutorService;
 * import java.util.concurrent.Executors;
 *
 * ExecutorService pool = Executors.newFixedThreadPool(
 *             Runtime.getRuntime().availableProcessors()
 *     );
 *
 *     pool.submit(new Runnable() {
 *         @Override
 *         public void run() {
 *             System.out.println("Execute " + Thread.currentThread().getName());
 *         }
 *     });
 *     pool.submit(new Runnable() {
 *         @Override
 *         public void run() {
 *             System.out.println("Execute " + Thread.currentThread().getName());
 *         }
 *     });
 *
 *     pool.shutdown();
 *     while (!pool.isTerminated()) {
 *         try {
 *             Thread.sleep(100);
 *         } catch (InterruptedException e) {
 *             e.printStackTrace();
 *         }
 *     }
 *     System.out.println("Execute " + Thread.currentThread().getName());
 * }
 *
 * Давайте разберемся в каждой строчке.
 *
 * ExecutorService pool = Executors.newFixedThreadPool(
 *             Runtime.getRuntime().availableProcessors()
 *     );
 *
 * Создает пул нитей по количеству доступных процессоров.
 *
 * pool.submit(new Runnable() {
 *         @Override
 *         public void run() {
 *             System.out.println("Execute " + Thread.currentThread().getName());
 *         }
 *     });
 * Добавляет задачу в пул и сразу ее выполняет.
 *
 *     pool.shutdown();
 *     while (!pool.isTerminated()) {
 *         try {
 *             Thread.sleep(100);
 *         } catch (InterruptedException e) {
 *             e.printStackTrace();
 *         }
 *     }
 * Закрываем пул и ждем пока все задачи завершаться.
 *
 * Если мы посмотрим внутрь реализации этого пула, то схема будет идентичная задаче  1. Реализовать ThreadPool [#1099]
 *
 * Задание.
 *
 * 1. Реализовать сервис для рассылки почты. Создайте класс EmailNotification.
 *
 * 2. В классе будет метод emailTo(User user) - он должен через ExecutorService отправлять почту.
 *
 * Так же добавьте метод close() - он должен закрыть pool. То есть в классе EmailNotification должно быть поле pool,
 * которые используется в emailTo и close().
 *
 * 3. Модель User описывают поля username, email.
 *
 * 4. Метод emailTo должен брать данные пользователя и подставлять в шаблон
 *
 * subject = Notification {username} to email {email}.
 *
 * body = Add a new event to {username}
 *
 * 5. создайте метод public void send(String suject, String body, String email) - он должен быть пустой.
 *
 * 6. Через ExecutorService создайте задачу, которая будет создать данные для пользователя и передавать их в метод send.
 *
 * 7. В своей папке добавьте задачу с этим именем.
 *
 * 8. Залейте код и укажите отвественного Петра Арсентьева.
 */
