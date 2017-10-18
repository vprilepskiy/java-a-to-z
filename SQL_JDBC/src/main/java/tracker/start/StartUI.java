package tracker.start;


import tracker.db.DB;
import tracker.db.SchemaDB;
import tracker.io.ConsoleOutput;
import tracker.io.Input;
import tracker.io.Output;
import tracker.io.ValidateInput;
import tracker.menu.MenuTracker;
import tracker.menu.Tracker;
import tracker.Settings;

/**
 * Класс для работы с заявками путем ввода и вывода строк.
 *
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
     *
     * @param input  - принемающий объект типа Input.
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
     *
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
        Settings settings = new Settings("DB.properties");

        final DB db = new DB();
        final String url = settings.getValue("url");
        final String username = settings.getValue("username");
        final String password = settings.getValue("password");
        db.setConnection(url, username, password);

        try {
            // создать структуру в БД.
            new SchemaDB(db).create(settings);

            Tracker tracker = new Tracker(db, settings);
            MenuTracker menu = new MenuTracker(this.input, this.output, tracker);
            this.range = menu.fillActions();

            do {
                menu.show();
                menu.select(input.ask("select: ", this.range));
            } while (!"y".equals(this.input.ask("Exit? y")));

        } finally {
            db.closeConnection();
        }
    }
}