package tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

import java.util.ArrayList;

/**
 * Класс.
 *
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 28.12.2016
 */
public class MenuTracker {

    /**
     * Метод ввода.
     */
    private Input input;
    /**
     * Метод вывода.
     */
    private Output output;
    /**
     * Мханизмы выполнения вводимых команд.
     */
    private Tracker tracker;
//    /**
//     * Кол-во действий.
//     */
//    private final int numberActions = 9;
    /**
     * Действие.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();
//    /**
//     * Номер свободной ячейки для объекта UserAction в меню.
//     */
//    private int position = 0;

    /**
     * Конструктор.
     *
     * @param input   - метод ввода.
     * @param output  - метод вывода.
     * @param tracker - трекер.
     */
    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }

    /**
     * Добавляет в массив действия.
     *
     * @param action - действие.
     */
    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    /**
     * Добавляет в массив действия и возвращает их rang.
     *
     * @return - массив доступных меню.
     */
    public int[] fillActions() {
        this.addAction(new AddItem("Add item", actions));
        this.addAction(new ShowItems("Show Items", actions));
        this.addAction(new EditItem("Edit Item", actions));
        this.addAction(new FindByName("Find By Name", actions));
        this.addAction(new FindByDesc("Find By Desc", actions));
        this.addAction(new FindByCreate("Find By Create", actions));
        this.addAction(new Delete("Delete", actions));
        this.addAction(new AddComens("AddComens", actions));

        int[] rangeItems = new int[this.actions.size()];
        int index = 0;
        for (UserAction userAction : this.actions) {
            if (userAction != null) {
                rangeItems[index] = userAction.key();
                index++;
            }
        }
        return rangeItems;
    }

    /**
     * Выполнить действие по номеру массива.
     *
     * @param key - элемент массива.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.output, this.tracker);
    }

    /**
     * Распечатывает меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Вернет массив доступных элементов в Tracker.
     *
     * @param tracker - Tracker.
     * @return - массив доступных элементов.
     */
    private int[] getRang(Tracker tracker) {
        ArrayList<Item> items = tracker.getAll();
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                index++;
            }
        }
        int[] rang = new int[index];
        index = 0;
        int indexItem = 0;
        for (Item item : items) {
            if (item != null) {
                rang[index] = indexItem;
                index++;
            }
            indexItem++;
        }
        return rang;
    }

    /**
     * Внутренний класс. Добавить запись.
     */
    private class AddItem extends BaseAction {
        /**
         * Добавть заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private AddItem(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's description: ");
            tracker.add(new Task(name, desc));
        }
    }


    /**
     * Внутренний класс. Показать все заявки.
     */
    private class ShowItems extends BaseAction {

        /**
         * Показать заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private ShowItems(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            output.answer(tracker.getAll());
        }
    }


    /**
     * Внутренний класс. Редактировать.
     */
    private class EditItem extends BaseAction {

        /**
         * Резактировать заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private EditItem(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int[] range = getRang(tracker);
            int index = input.ask("Please enter the number task: ", range);
            String id = tracker.getAll().get(index).getId();
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's description: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.update(task);
        }
    }

    /**
     * Внутренний класс. Найти по имени.
     */
    private class FindByName extends BaseAction {

        /**
         * Найти заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private FindByName(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            output.answer(tracker.findByName(name));
        }
    }

    /**
     * Внутренний класс. Найти по описанию.
     */
    private class FindByDesc extends BaseAction {

        /**
         * Найти заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private FindByDesc(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String desc = input.ask("Please enter the task's desc: ");
            output.answer(tracker.findByDescription(desc));
        }
    }

    /**
     * Внутренний класс. Найти времени создания.
     */
    private class FindByCreate extends BaseAction {

        /**
         * Найти заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private FindByCreate(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String create = input.ask("Please enter the task's create: ");
            output.answer(tracker.findByCreate(Long.parseLong(create)));
        }
    }

    /**
     * Внутренний класс. Удалить запись.
     */
    private class Delete extends BaseAction {

        /**
         * Удалит заявку.
         * @param name - название метода.
         * @param actions - действие.
         */
        private Delete(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int[] range = getRang(tracker);
            int index = input.ask("Please enter the number task: ", range);
            tracker.del(tracker.getAll().get(index));
        }
    }

    /**
     * Внутренний класс. Добавить коментарии.
     */
    private class AddComens extends BaseAction {

        /**
         * Добавить коментарии.
         * @param name - название метода.
         * @param actions - действие.
         */
        private AddComens(String name, ArrayList<UserAction> actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int index = Integer.parseInt(input.ask("Please enter the number task: "));
            String comment = input.ask("Please enter comment: ");
            tracker.addComment(tracker.getAll().get(index), comment);
        }
    }
}