package jmm;

import org.junit.Test;

/**
 * Created by VLADIMIR on 27.09.2017.
 */
public class AsynchronousAccessTest {
    /**
     * Test.
     */
    @Test
    public void count() {

        final int numberOfIterations = 10;

        for (int i = 0; i < numberOfIterations; i++) {
            int x = new AsynchronousAccess().count();
            System.out.println(x);
        }

    }

}