package array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


/**
 * Created by VLADIMIR on 08.11.2017.
 */
public class CombinatoricsRefactorTest {

    /**
     * Test.
     *
     * @throws Exception - ex.
     */
    @Test
    public void allVariantsOfPermutations() throws Exception {
        // data
        final int[] arr = new int[]{1, 2, 3, 4};

        // result
        final List<int[]> result = new CombinatoricsRefactor().allVariantsOfPermutations(arr);

        // expect
        final int[][] expect = {
                {1, 2, 3, 4},
                {2, 1, 3, 4},
                {3, 1, 2, 4},
                {4, 1, 2, 3},
                {1, 3, 2, 4},
                {1, 4, 2, 3},
                {2, 3, 1, 4},
                {2, 4, 1, 3},
                {3, 2, 1, 4},
                {3, 4, 1, 2},
                {4, 2, 1, 3},
                {4, 3, 1, 2},
                {1, 2, 4, 3},
                {2, 1, 4, 3},
                {3, 1, 4, 2},
                {4, 1, 3, 2},
                {1, 3, 4, 2},
                {1, 4, 3, 2},
                {2, 3, 4, 1},
                {2, 4, 3, 1},
                {3, 2, 4, 1},
                {3, 4, 2, 1},
                {4, 2, 3, 1},
                {4, 3, 2, 1}
        };

        // Assert
        Assert.assertThat(result.toArray(), Is.is(expect));

    }
}