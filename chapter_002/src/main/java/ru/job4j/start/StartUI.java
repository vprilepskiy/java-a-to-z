package ru.job4j.start;

/**
 * Класс для работы с заявками путем ввода и вывода строк.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 28.12.2016
 */
public class StartUI {

	/**
	 * Ввод.
	 */
	private Input input;
	/**
	 * Вывод.
	 */
	private Output output;

	/**
	 * Конструктор.
	 * @param input - принемающий объект типа Input.
	 * @param output - принемающий объект типа Output.
	 */
	public StartUI(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * Массив разрешенных пунктов меню.
	 */
	private int[] range;

	/**
	 * Точка входа.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		Input input = new ValidateInput();
		Output output = new ConsoleOutput();
		new StartUI(input, output).init();
	}

	/**
	 * Консольная работа.
	 */
	public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input, this.output, tracker);
		this.range = menu.fillActions();

		do {
			menu.show();
			menu.select(input.ask("select: ", this.range));
		} while (! "y".equals(this.input.ask("Etit? y")));
	}



//	public void init() {
//	Tracker tracker = new Tracker();
//	String nextLine = System.getProperty("line.separator");
//	String hello = "Welcome to accounting software applications.";
//	String supportedCommands = "Supported commands:" + nextLine
//			+ "add \t for add row" + nextLine
//			+ "update \t for update the row" + nextLine
//			+ "delete \t to remove by index" + nextLine
//			+ "getAll \t show all rows" + nextLine
//			+ "findByName \t find by name" + nextLine
//			+ "findByDesc \t find by description" + nextLine
//			+ "findByCreate \t find by moment create" + nextLine
//			+ "addComent \t add comments" + nextLine
//			+ "exit \t for exit" + nextLine;
//	System.out.println(hello + nextLine + supportedCommands);
//
//	boolean retry = true;
//	while (retry) {
//		String command = input.ask("Please enter command: ");
//		// добавить
//		if (command.equals("add")) {
//			String name = input.ask("Please enter the task's name: ");
//			String desc = input.ask("Please enter the task's description: ");
//			tracker.add(new Task(name, desc));
//		// заменить
//		} else if (command.equals("update")) {
//			int index = Integer.parseInt(input.ask("Please enter the number task: "));
//			String id = tracker.getAll()[index].getId();
//			String name = input.ask("Please enter the task's name: ");
//			String desc = input.ask("Please enter the task's description: ");
//			Task task = new Task(name, desc);
//			task.setId(id);
//			tracker.update(task);
//		// удалить
//		} else if (command.equals("delete")) {
//			int index = Integer.parseInt(input.ask("Please enter the number task: "));
//			tracker.del(tracker.getAll()[index]);
//		// показать все
//		} else if (command.equals("getAll")) {
//			output.answer(tracker.getAll());
//		// найти по имени
//		} else if (command.equals("findByName")) {
//			String name = input.ask("Please enter the task's name: ");
//			output.answer(tracker.findByName(name));
//		// найти по описанию
//		} else if (command.equals("findByDesc")) {
//			String desc = input.ask("Please enter the task's desc: ");
//			output.answer(tracker.findByDescription(desc));
//		// найти по времени создания
//		} else if (command.equals("findByCreate")) {
//			String create = input.ask("Please enter the task's create: ");
//			output.answer(tracker.findByCreate(Long.parseLong(create)));
//		// добавить комментарии
//		} else if (command.equals("addComent")) {
//			int index = Integer.parseInt(input.ask("Please enter the number task: "));
//			String comment = input.ask("Please enter comment: ");
//			tracker.addComment(tracker.getAll()[index], comment);
//		// выйти
//		} else if (command.equals("exit")) {
//			retry = false;
//		// неверная команда
//		} else {
//			System.out.println("\"" + command + "\"" + " Not found command" + nextLine + supportedCommands);
//		}
//	}
//}
}