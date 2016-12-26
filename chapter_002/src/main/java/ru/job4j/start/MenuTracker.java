package ru.job4j.start;

import ru.job4j.models.Task;
import ru.job4j.models.Item;

/**
 * Внешний класс. Редактировать.
 */
class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        // задали вопрос, получили ответ
		int index = Integer.parseInt(input.ask("Please enter the number task: "));
		String id = tracker.getAll()[index].getId();
		String name = input.ask("Please enter the task's name: ");
		String desc = input.ask("Please enter the task's description: ");
		Task task = new Task(name, desc);
		task.setId(id);
		tracker.update(task);
		// записали ответ в Tracker
        tracker.update(task);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
    }
}

/**
 * Класс.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 25.12.2016
 */
public class MenuTracker {

    private Input input;
    private Output output;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];

    /**
     * Конструктор.
     */
    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new FindByName();
        this.actions[4] = new FindByDesc();
        this.actions[5] = new FindByCreate();
        this.actions[6] = new Delete();
        this.actions[7] = new AddComens();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.output, this.tracker);
    }

    /**
     * Распечатывает меню.
     */
    public void show(){
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }

        }
    }

    /**
     * Внутренний класс. Добавить запись.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            // задали вопрос, получили ответ
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's description: ");
//		    // записали ответ в Tracker
		    tracker.add(new Task(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Внутренний класс. Показать все заявки.
     */
    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            output.answer(tracker.getAll());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Внутренний класс. Найти по имени.
     */
    private class FindByName implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
			String name = input.ask("Please enter the task's name: ");
			output.answer(tracker.findByName(name));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find By Name.");
        }
    }

    /**
     * Внутренний класс. Найти по описанию.
     */
    private class FindByDesc implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String desc = input.ask("Please enter the task's desc: ");
            output.answer(tracker.findByDescription(desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find By Description.");
        }
    }

    /**
     * Внутренний класс. Найти времени создания.
     */
    private class FindByCreate implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String create = input.ask("Please enter the task's create: ");
            output.answer(tracker.findByCreate(Long.parseLong(create)));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find By Create.");
        }
    }

    /**
     * Внутренний класс. Удалить запись.
     */
    private class Delete implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
			int index = Integer.parseInt(input.ask("Please enter the number task: "));
			tracker.del(tracker.getAll()[index]);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Внутренний класс. Найти по описанию.
     */
    private class AddComens implements UserAction {

        @Override
        public int key() {
            return 7;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
			int index = Integer.parseInt(input.ask("Please enter the number task: "));
			String comment = input.ask("Please enter comment: ");
			tracker.addComment(tracker.getAll()[index], comment);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add Comens.");
        }
    }
}
