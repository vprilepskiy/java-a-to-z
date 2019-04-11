package synchronize.task2;

/*
* 2. Класс хранилища пользователей UserStorage [#1104]
  Петр Арсентьев,  09.11.17 17:19
1. Создать класс - структуру данных для хранение пользователей UserStorage.
2. В заголовке класса обозначить аннотацию @ThreadSafe из библиотеки

<dependency>
    <groupId>net.jcip</groupId>
    <artifactId>jcip-annotations</artifactId>
    <version>1.0</version>
</dependency>

3. Хранилище должно иметь методы boolean add (User user), boolean update(User user), boolean delete(User user).

4. И особый метод transfer(int fromId, int toId, int amount);

5. Структура данных должна быть потокобезопасная;

6. В структуре User Должны быть поля int id, int amount.

amount - это сумма денег на счете пользователя.

Пример. использования.

UserStore stoge = new UserStore();

stoge.add(new User(1, 100));
stoge.add(new User(2, 200));

stoge.transfer(1, 2, 50);

* */