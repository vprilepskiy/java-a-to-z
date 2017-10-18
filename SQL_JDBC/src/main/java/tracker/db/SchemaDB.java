package tracker.db;

import tracker.Settings;

/**
 * Created by VLADIMIR on 16.10.2017.
 *
 * Create a database structure if it does not exist.
 */
public class SchemaDB {


    /**
     * Data base.
     */
    private final DB db;


    /**
     * Constructor.
     * @param db - Data base.
     */
    public SchemaDB(DB db) {
        this.db = db;
    }


    /**
     * Checks the existence of tables and creates if there is no.
     * @param settings - settings.
     */
    public void create(Settings settings) {
        // менеджер работы с БД
        DB.Manager manager = db.new Manager();

        // запрос названия таблицы
        String selectTableName = settings.getValue("SQL_SELECT_TABLE");

        // если таблица отсутствует
        if (manager.getSelect(selectTableName, "items").isEmpty()) {
            // создать таблицу
            String createTable = settings.getValue("SQL_CREATE_ITEMS");
            manager.update(createTable);
        }

        // если таблица отсутствует
        if (manager.getSelect(selectTableName, "comments").isEmpty()) {
            // создать таблицу
            String createTable = settings.getValue("SQL_CREATE_COMMENTS");
            manager.update(createTable);
        }
    }
}
