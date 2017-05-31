/**
 * 5.2.2. Реализовать IStore<T extends Base>
 * Сделать интерфейс IStore<T extends Base> где Base
 * Это абстрактный класс для моделей c методами String getId(); void setId(String id).
 *
 *   1. Сделать два класса User, и Role которые наследуют данный класс.
 *   2. Сделать два хранилища UserStore и RoleStore. Внутри для хранения данных использовать SimpleArray.
 *   3. Методы добавить, обновить, удалить.
 *   4. Помните. про инкапсуляцию. В методах store нельзя использовать методы c index.
 *
 * Created by VLADIMIR on 30.05.2017.
 */
package ru.job4j.generic.store;