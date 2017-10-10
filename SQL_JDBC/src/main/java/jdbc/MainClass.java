package jdbc;

import jdbc.db.DB;
import jdbc.xml.Entries;
import jdbc.xml.Entry;
import jdbc.xml.XMLMagic;

import java.io.File;
import java.util.List;

/**
 * Created by VLADIMIR on 10.10.2017.
 */
public class MainClass implements IMainClass {

    /**
     * Url.
     */
    private String url;
    /**
     * Username.
     */
    private String username;
    /**
     * Password.
     */
    private String password;
    /**
     * Number.
     */
    private int number;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() throws MyException {

        // если не переданы строки соединения
        if (this.url == null || this.username == null || this.password == null || this.number <= 0) {
            throw new MyException("Invalid initialization parameters!!!");
        }

        // соедениться с БД
        DB db = new DB();
        db.setConnection(this.url, this.username, this.password);

        // менеджер работы с БД
        DB.Manager manager = new DB.Manager();
        // запрос названия таблицы
        String selectTableTest = "SELECT table_name FROM information_schema.tables WHERE table_name = 'test'";

        // если таблица отсутствует
        if (manager.getRows(selectTableTest).isEmpty()) {
            // создать таблицу
            String createTable = "CREATE TABLE test (field INTEGER)";
            manager.update(createTable);
        }

        // если таблица не пустая
        if (!manager.getRows("SELECT field FROM test", 1).isEmpty()) {
            // удалить данные из таблицы
            manager.update("TRUNCATE TABLE test");
        }
        // добавить данные в таблицу
        manager.insertMultipleRows("INSERT INTO test (field) VALUES (?)", this.number);
        // запросить данные из таблицы
        List<Entry> entryList = manager.getRows("SELECT field FROM test");
        // закрыть соединение с БД
        db.closeConnection();

        // преобразовать к объекту Entries
        Entries entries = new Entries();
        entries.setList(entryList);

        // сохранить Entries в XML
        new XMLMagic().objectsToXMLFile(entries, new File("1.xml"));
        // преобразовать с полощю XSLT
        new XMLMagic().transformXSL(new File("1.xml"), new File("Style.xsl"), new File("2.xml"));
        // сделать запрос с помощью XPath
        System.out.println(new XMLMagic().requestXPath(new File("2.xml"), "sum(/entries/entry/@field)"));
    }



}
