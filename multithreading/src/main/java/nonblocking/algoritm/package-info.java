package nonblocking.algoritm;
/**
 * 1. Неблокирующий кеш [#4741]
 *   Петр Арсентьев,  16.08.18 9:25
 *  1. Необходимо сделать кеш для хранение моделей. в кеше должны быть методы
 * add(Base model), update(Base model) delete(Base model),
 *
 * class Base {
 *    int id
 *    int version
 * }
 *
 * 2. Для хранения данных в кеше нужно использовать ConcurrentHashMap<Integer, Base>.
 *
 * В качестве ключа используйте int id. в качестве значения Base модель
 *
 * 3. В кеше должна быть возможность проверять актуальность данных. Для этого в модели данных должно быть после int version.
 * Это после должно увеличиваться на единицу каждый раз, когда произвели изменения данных в модели.
 * Например. Два пользователя прочитали данные task_1
 * первый пользователь изменил поле имя и второй сделал тоже самое. нужно перед обновлением данных проверить. что текущий пользователь не затер данные другого пользователя. если данные затерты то выбросить OptimisticException - такая реализация достигается за счет введение в модель поля version. Перед обновлением данных необходимо проверять текущую версию и ту что обновляем и увеличивать на единицу каждый раз, когда произошло обновление. Если версии не равны -  кидать исключение.
 *
 * Исключение - OptimisticException нужно сделать самостоятельно.
 *
 * public class OptimisticException extends RuntimeException {
 * }
 *
 * Исключение должно быть RuntimeException, так как обработчик для BiFunction не может кидать исключение.
 *
 * Использовать метод https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html#computeIfPresent-K-java.util.function.BiFunction-
 *
 * Пример.
 *
 * Нить 1 изменила объект 1, тогда version должно стать 1.
 * Нить 2 в это же время изменила объект 1, тут тоже самое version станет 1.
 *
 * Объекты 1 - создаются в разной области памяти. По сути эти два разных объекта с одинаковыми полями.
 *
 * Когда нить 1 будет обновлять данные, обновление пройдет успешно. потому что данные в кеше будут на единицу отличаться.
 *
 * С другой стороны нить 2 выкинет исключение. потому, что версия в кеше не будет соответствовать текущей версии.
 *
 * Тесты.
 *
 * Если мы запускаем нить в тесте, то ошибки в этой нити не будут влиять на результат теста.
 *
 * Посмотри код.
 *
 * public class CatchException {
 *     @Test
 *     public void whenThrowException() throws InterruptedException {
 *         Thread thread = new Thread(
 *                 () -> {
 *                     throw new RuntimeException("Throw Exception in Thread");
 *                 }
 *         );
 *         thread.start();
 *         thread.join();
 *     }
 * }
 *
 * Тест выполняется успешно. Это связано с тем, что главная нить не видит, что происходит во второстепенной нити.
 *
 * Чтобы это поправить нам нужно передать исключение к главную нить.
 *
 * public class CatchException {
 *     @Test
 *     public void whenThrowException() throws InterruptedException {
 *         AtomicReference<Exception> ex = new AtomicReference<>();
 *         Thread thread = new Thread(
 *                 () -> {
 *                     try {
 *                         throw new RuntimeException("Throw Exception in Thread");
 *                     } catch (Exception e) {
 *                         ex.set(e);
 *                     }
 *                 }
 *         );
 *         thread.start();
 *         thread.join();
 *         Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
 *     }
 * }
 *
 * Теперь мы можем проверить, что такой код падает.
 */