package tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


/**
 * Created by VLADIMIR on 18.10.2017.
 */
public class SettingsTest {

    /**
     * Test.
     * @throws IOException - ex.
     */
    @Test
    public void getValue() throws IOException {

        Settings settings = new Settings("DB.properties");
        Assert.assertThat("test", Is.is(settings.getValue("test")));

    }
}