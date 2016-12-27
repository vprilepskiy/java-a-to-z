package ru.job4j.start;

/**
 * Класс для тестирования.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 27.12.2016
 */
public class StartUITest {

	/**
	 * Точка входа.
	 * @param args - args.
	 */
	public static void main(String[] args) {

//		String[] answers = {"add", "Name0", "Desc0",
//				"add", "Name1", "Desc1",
//				"add", "Name2", "Desc2",
//				"getAll",
//			//	"update", "0", "Name0_editing", "Desc0_editing",
//			//	"getAll",
//			//	"delete", "1",
//			//	"getAll",
//				"exit"
//		};

		String[] answers = {"0", "Name0", "Desc0",
				"n",
				"0", "Name1", "Desc1",
				"n",
				"0", "Name2", "Desc2",
				"n",
				"2",
				"2", "Name2_editing", "Desc2_editing",
				"n",
				"1",
				"y"
		};

		Input input = new StabInput(answers);
		Output output = new StubOutput();
		new StartUI(input, output).init();
		String[] asks = ((StubOutput) output).getAsks();

		for (String ask : asks) {
			if (ask != null) {
				System.out.println("StartUITest: " + ask);
			}
		}
	}
}