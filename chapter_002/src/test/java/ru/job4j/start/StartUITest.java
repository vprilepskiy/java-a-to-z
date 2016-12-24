package ru.job4j.start;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Vladimir Prilepskiy
 * @since 24.12.2016
 * @version 1
 */
public class StartUITest {

    /**
     * Рередает команды и возвращает ответы.
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
     * Test.
     */
    @Test
    public void whenToAddItemAndGetAll() {
        final String[] answers = {"add", "Name0", "Desc0",
                "add", "Name1", "Desc1",
                "add", "Name2", "Desc2",
                "getAll",
                "exit"
        };
        final String[] ask = {"№ 0; name: Name0; desc: Desc0; create: 0",
                "№ 1; name: Name1; desc: Desc1; create: 0",
                "№ 2; name: Name2; desc: Desc2; create: 0"
        };
        assertThat(getAsks(answers), is(ask));
    }

    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndEditAndGetAll() {
        final String[] answers = {"add", "Name0", "Desc0",
                "add", "Name1", "Desc1",
                "add", "Name2", "Desc2",
                "update", "0", "Name0_editing", "Desc0_editing",
                "getAll",
                "exit"
        };
        final String[] ask = {"№ 0; name: Name0_editing; desc: Desc0_editing; create: 0",
                "№ 1; name: Name1; desc: Desc1; create: 0",
                "№ 2; name: Name2; desc: Desc2; create: 0"
        };
        assertThat(getAsks(answers), is(ask));
    }

    /**
     * Test.
     */
    @Test
    public void whenToAddItemAndDeleteAndGetAll() {
        final String[] answers = {"add", "Name0", "Desc0",
                "add", "Name1", "Desc1",
                "add", "Name2", "Desc2",
                "delete", "1",
                "getAll",
                "exit"
        };
        final String[] ask = {"№ 0; name: Name0; desc: Desc0; create: 0",
                null,
                "№ 2; name: Name2; desc: Desc2; create: 0"
        };
        assertThat(getAsks(answers), is(ask));
    }
}