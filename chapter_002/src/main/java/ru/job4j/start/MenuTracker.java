package ru.job4j.start;

import ru.job4j.models.Task;
import ru.job4j.models.Item;

/**
 * Внешний класс.
 */
class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        // задали вопрос, получили ответ
        String id = input.ask("Please enter the task's id: ");
        String name = input.ask("Please enter the task's name: ");
        String desc = input.ask("Please enter the task's description: ");
        Task task = new Task(name, desc);
        task.setId(id);
//		// записали ответ в Tracker
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
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    /**
     * Конструктор.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        // задали вопрос, получили ответ
        String name = input.ask("Please enter the task's name: ");
        String desc = input.ask("Please enter the task's description: ");
//		Tracker tracker = new Tracker();
//		// записали ответ в Tracker
		tracker.add(new Task(name, desc));
//		// вывели на экран все заявки
//		for (Item item : tracker.getAll()){
//			System.out.println(item.getName());
//		}

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
		// вывели на экран все заявки
		    for (Item item : tracker.getAll()){
			    //System.out.println(item.getName());
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
		    }

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

}
