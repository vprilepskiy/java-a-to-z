package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

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
    /**
     * Действие.
     */
    private UserAction[] actions = new UserAction[9];
    /**
     * Номер свободной ячейки для объекта UserAction в меню.
     */
    private int position = 0;

    /**
     * Конструктор.
     */
    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }

    /**
     * Добавляет в массив действия.
     * @param action - действие.
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * Добавляет в массив действия и возвращает их rang.
     * @return - массив доступных меню.
     */
    public int[] fillActions() {
        addAction(new AddItem("Add item", actions));
        addAction(new ShowItems("Show Items", actions));
        addAction(new EditItem("Edit Item", actions));
        addAction(new FindByName("Find By Name", actions));
        addAction(new FindByDesc("Find By Desc", actions));
        addAction(new FindByCreate("Find By Create", actions));
        addAction(new Delete("Delete", actions));
        addAction(new AddComens("AddComens", actions));

        int[] rangeItems = new int[this.actions.length];
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
     * @param key - элемент массива.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.output, this.tracker);
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
     * @param tracker - Tracker.
     * @return - массив доступных элементов.
     */
    public int[] getRang(Tracker tracker) {
        Item[] items = tracker.getAll();
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                index++;
            }
        }
        int rang[] = new int[index];
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

        public AddItem(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's description: ");
            tracker.add(new Task(name, desc));
        }
    }
    // private class AddItem implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for(UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // // задали вопрос, получили ответ
    // String name = input.ask("Please enter the task's name: ");
    // String desc = input.ask("Please enter the task's description: ");
    //// // записали ответ в Tracker
    // tracker.add(new Task(name, desc));
    // }
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Add the new item.");
    // }
    // }

    /**
     * Внутренний класс. Показать все заявки.
     */
    private class ShowItems extends BaseAction {

        public ShowItems(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            output.answer(tracker.getAll());
        }
    }
    // private class ShowItems implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for(UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // output.answer(tracker.getAll());
    // }
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Show all items.");
    // }
    // }

    /**
     * Внутренний класс. Редактировать.
     */
    private class EditItem extends BaseAction {

        public EditItem(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int[] range = getRang(tracker);
            int index = input.ask("Please enter the number task: ", range);
            String id = tracker.getAll()[index].getId();
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's description: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.update(task);
        }
    }
    // private class EditItem implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for(UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // // задали вопрос, получили ответ
    // int[] range = getRang(tracker);
    // int index = input.ask("Please enter the number task: ", range);
    // String id = tracker.getAll()[index].getId();
    // String name = input.ask("Please enter the task's name: ");
    // String desc = input.ask("Please enter the task's description: ");
    // Task task = new Task(name, desc);
    // task.setId(id);
    // tracker.update(task);
    // // записали ответ в Tracker
    // tracker.update(task);
    // }
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Edit item.");
    // }
    // }

    /**
     * Внутренний класс. Найти по имени.
     */
    private class FindByName extends BaseAction {

        public FindByName(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            output.answer(tracker.findByName(name));
        }
    }
    // private class FindByName implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for(UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // String name = input.ask("Please enter the task's name: ");
    // output.answer(tracker.findByName(name));
    // }
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Find By Name.");
    // }
    // }

    /**
     * Внутренний класс. Найти по описанию.
     */
    private class FindByDesc extends BaseAction {

        public FindByDesc(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String desc = input.ask("Please enter the task's desc: ");
            output.answer(tracker.findByDescription(desc));
        }

    }
    // private class FindByDesc implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for (UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    //
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // String desc = input.ask("Please enter the task's desc: ");
    // output.answer(tracker.findByDescription(desc));
    // }
    //
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Find By Description.");
    // }
    // }

    /**
     * Внутренний класс. Найти времени создания.
     */
    private class FindByCreate extends BaseAction {

        public FindByCreate(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String create = input.ask("Please enter the task's create: ");
            output.answer(tracker.findByCreate(Long.parseLong(create)));
        }
    }
    // private class FindByCreate implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for (UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    //
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // String create = input.ask("Please enter the task's create: ");
    // output.answer(tracker.findByCreate(Long.parseLong(create)));
    // }
    //
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Find By Create.");
    // }
    // }

    /**
     * Внутренний класс. Удалить запись.
     */
    private class Delete extends BaseAction {

        public Delete(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int[] range = getRang(tracker);
            int index = input.ask("Please enter the number task: ", range);
            tracker.del(tracker.getAll()[index]);
        }
    }
    // private class Delete implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for (UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    //
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // int[] range = getRang(tracker);
    // int index = input.ask("Please enter the number task: ", range);
    // tracker.del(tracker.getAll()[index]);
    // }
    //
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Delete item.");
    // }
    // }

    /**
     * Внутренний класс. Найти по описанию.
     */
    private class AddComens extends BaseAction {

        public AddComens(String name, UserAction[] actions) {
            super(name, actions);
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            int index = Integer.parseInt(input.ask("Please enter the number task: "));
            String comment = input.ask("Please enter comment: ");
            tracker.addComment(tracker.getAll()[index], comment);
        }
    }
    // private class AddComens implements UserAction {
    // @Override
    // public int key() {
    // int key = -1;
    // int index = 0;
    // for (UserAction userAction : actions) {
    // if (userAction != null && userAction == this) {
    // key = index;
    // }
    // index++;
    // }
    // return key;
    // }
    //
    // @Override
    // public void execute(Input input, Output output, Tracker tracker) {
    // int index = Integer.parseInt(input.ask("Please enter the number task:
    // "));
    // String comment = input.ask("Please enter comment: ");
    // tracker.addComment(tracker.getAll()[index], comment);
    // }
    //
    // @Override
    // public String info() {
    // return String.format("%s. %s", this.key(), "Add Comens.");
    // }
    // }
}