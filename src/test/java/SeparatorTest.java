import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeparatorTest {
    @Test
    public void goodTest1() throws SeparatorException {
        int a[] = {4,5,6,7,8,9};
        List<List<Integer>> list = Separator.separate(a, 3);

        assertAll(
                () -> assertTrue(list.get(0).contains(4)),
                () -> assertTrue(list.get(0).contains(9)),
                () -> assertTrue(list.get(1).contains(5)),
                () -> assertTrue(list.get(1).contains(8)),
                () -> assertTrue(list.get(2).contains(6)),
                () -> assertTrue(list.get(2).contains(7))
        );
    }

    @Test
    public void goodTest2() throws SeparatorException {
        int a[] = {1,1,1,1,1,1,1,2};
        List<List<Integer>> list = Separator.separate(a, 3);

        assertAll(
                () -> assertEquals(list.get(0).get(0), 1),
                () -> assertEquals(list.get(0).get(1), 1),
                () -> assertEquals(list.get(0).get(2), 1),
                () -> assertEquals(list.get(1).get(0), 1),
                () -> assertEquals(list.get(1).get(1), 1),
                () -> assertEquals(list.get(1).get(2), 1),
                () -> assertEquals(list.get(2).get(0), 1),
                () -> assertEquals(list.get(2).get(1), 2)
        );
    }

    @Test
    public void goodTest3() throws SeparatorException {
        int a[] = {0};
        List<List<Integer>> list = Separator.separate(a, 3);

        assertAll(
                () -> assertEquals(list.get(0).get(0), 0),
                () -> assertEquals(list.get(1).size(), 0),
                () -> assertEquals(list.get(2).size(), 0)
        );
    }

    @Test
    public void cheatTest1() throws SeparatorException {
        int a[] = {1,1,1,1,1,1,1,1,1,1,9,9,2};
        List<List<Integer>> list = Separator.separate(a, 3);

        assertAll(
                () -> assertEquals(list.get(0).get(0), 1),
                () -> assertEquals(list.get(0).get(1), 1),
                () -> assertEquals(list.get(0).get(2), 1),
                () -> assertEquals(list.get(0).get(3), 1),
                () -> assertEquals(list.get(0).get(4), 1),
                () -> assertEquals(list.get(0).get(5), 1),
                () -> assertEquals(list.get(0).get(6), 1),
                () -> assertEquals(list.get(0).get(7), 1),
                () -> assertEquals(list.get(0).get(8), 2),
                () -> assertEquals(list.get(1).get(0), 1),
                () -> assertEquals(list.get(1).get(1), 9),
                () -> assertEquals(list.get(2).get(0), 1),
                () -> assertEquals(list.get(2).get(1), 9)
        );
    }


    @Test
    public void badTest1() throws SeparatorException {
        int a[] = {3};
        List<List<Integer>> list = Separator.separate(a, 3);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void badTest2() throws SeparatorException {
        int a[] = {1,1,1,1,1,1,1,2,12};
        List<List<Integer>> list = Separator.separate(a, 3);
        Assert.assertEquals(list.size(), 0);
    }
}
