package ru.job4j.tracker.start;

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
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "1",
                "y"
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
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "2", "0", "Name0_editing", "Desc0_editing", "n",
                "1",
                "y"
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
        final String[] answers = {"0", "Name0", "Desc0", "n",
                "0", "Name1", "Desc1", "n",
                "0", "Name2", "Desc2", "n",
                "6", "1", "n",
                "1",
                "y"
        };
        final String[] ask = {"№ 0; name: Name0; desc: Desc0; create: 0",
                "№ 1; name: Name2; desc: Desc2; create: 0"
        };
        assertThat(getAsks(answers), is(ask));
    }
}