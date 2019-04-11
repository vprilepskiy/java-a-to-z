package nonblocking.algoritm;

import org.junit.Assert;
import org.junit.Test;

public class NonBlockingCacheTest {

    private final NonBlockingCache cache = new NonBlockingCache();

    @Test
    public void testOk() {
        Base base = new Base(0, 0);
        cache.add(base);
        cache.update(base);

        Assert.assertEquals(base, new Base(0, 1));
    }

    @Test
    public void testFail() {
        Base base = new Base(0, 0);
        cache.add(base);
        cache.update(base);

        Exception exception = null;
        try {
            cache.update(new Base(0, 0));
        } catch (OptimisticException e) {
            exception = e;
        }

        Assert.assertNotNull(exception);
    }
}