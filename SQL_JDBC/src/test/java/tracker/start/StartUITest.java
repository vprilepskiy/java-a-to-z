package tracker.start;

import org.junit.Before;
import org.junit.Test;
import tracker.db.DB;
import tracker.db.SchemaDB;
import tracker.io.Input;
import tracker.io.Output;
import tracker.io.StabInput;
import tracker.io.StubOutput;
import tracker.Settings;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by VLADIMIR on 18.10.2017.
 */
public class StartUITest {

    /**
     * DB.
     */
    private final DB db = new DB();



    /**
     * Предварительно очистим таблицу.
     */
    @Before
    public void delAllRows() {
        final Settings settings = new Settings("DB.properties");
        this.db.setConnection(settings.getValue("url"), settings.getValue("username"), settings.getValue("password"));
        final DB.Manager manager = db.new Manager();
        new SchemaDB(db).create(settings);
        manager.update("TRUNCATE TABLE items RESTART IDENTITY CASCADE");
        manager.update("TRUNCATE TABLE comments RESTART IDENTITY CASCADE");
        this.db.closeConnection();
    }



    /**
     * Передает команды и возвращает ответы.
     * @param answers - команды.
     * @return - ответы.
     */
    public String[] getAsks(String[] answers) {
        Input input = new StabInput(answers);
        Output output = new StubOutput();
        new StartUI(input, output).init();
        return ((StubOutput) output).getAsks();
    }



    /**
     * Test Add.
     */
    @Test
    public void whenToAddItemAndGetAll() {
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "1",
                "y"
        };
        final String[] ask = {"№ 1; name: Name0; desc: Desc0",
                "№ 2; name: Name1; desc: Desc1",
                "№ 3; name: Name2; desc: Desc2"
        };
        assertThat(getAsks(answers), is(ask));
    }



    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndEditAndGetAll() {
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "2", "1", "Name0_editing", "Desc0_editing", "n",
                "1",
                "y"
        };
        final String[] ask = {"№ 1; name: Name0_editing; desc: Desc0_editing",
                "№ 2; name: Name1; desc: Desc1",
                "№ 3; name: Name2; desc: Desc2"
        };
        assertThat(getAsks(answers), is(ask));
    }



    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndDeleteAndGetAll() {
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "6", "1", "n",
                "1",
                "y"
        };
        final String[] ask = {"№ 1; name: Name0; desc: Desc0",
                "№ 3; name: Name2; desc: Desc2"
        };
        assertThat(getAsks(answers), is(ask));
    }


    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndFindByName() {
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "3", "Name0",
                "y"
        };
        final String[] ask = {"№ 1; name: Name0; desc: Desc0"};
        assertThat(getAsks(answers), is(ask));
    }



    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndFindByDesc() {
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "4", "Desc1",
                "y"
        };
        final String[] ask = {"№ 2; name: Name1; desc: Desc1"};
        assertThat(getAsks(answers), is(ask));
    }




}