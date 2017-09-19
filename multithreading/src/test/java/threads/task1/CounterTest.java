package threads.task1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 18.09.2017.
 */
public class CounterTest {

    /**
     * Data.
     */
    private final String data = "Hello world job for java";



    /**
     * Test.
     */
    @Test
    public void space() {
        final int expect = 4;
        final int result = new Counter(data).space();
        Assert.assertThat(result, Is.is(expect));
    }



    /**
     * Test.
     */
    @Test
    public void words() {
        final int expect = 5;
        final int result = new Counter(data).words();
        Assert.assertThat(result, Is.is(expect));
    }


}