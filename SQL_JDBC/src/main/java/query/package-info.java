/**
 * Created by VLADIMIR on 27.09.2017.
 */
package query;
/**
 * Фильтры [#1732]
 Петр Арсентьев,  01.09.16 8:21
 Данная задача является предпосылкой к пользовательскому интерфейсу. В интерфейсе у пользователя есть раздел - создать фильтры. При создании фильтра пользователь указывает имя фильтра и критерии. Критерии могут быть как простые условия - равно, меньше, больше, так и сложные, составные И или ИЛИ.
 В приложении у пользователя должна быть возможность фильтровать заявки по различным критериям. Необходимо разработать модель данных, которая описывает данное поведение. Фильтры должны выполнять как простые условия. Равно полю, Больше или меньше, так и составные.
 Написать пример запросов в базу данных демонстрирующие работу модели из первого задания.
 Если у заказчика появиться требование добавить новое поле в заявку, сможет ли ваша модель учитывать эти условия без кардинальных изменений кода?
 Пример.
 Заявка содержит поле описание description.
 Пользователь создал фильтр с критерием - описание должно содержать слово - DIT.
 Система должна сохранить данные критерии.
 Когда пользователь выбирает данных фильтр система должна сгенерировать запрос
 SELECT * FROM items AS i WHERE i.description LIKE '%DIT%';

 *
 */