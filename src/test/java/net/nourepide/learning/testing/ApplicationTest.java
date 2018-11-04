package net.nourepide.learning.testing;

import org.junit.jupiter.api.Test;

import static net.nourepide.learning.testing.Application.changeArray;
import static net.nourepide.learning.testing.Application.checkArray;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void checkArrayTest() {
        assertTrue(checkArray(new int[]{1, 4}, 1, 4));

        assertFalse(checkArray(new int[]{4, 4}, 1, 4));

        assertFalse(checkArray(new int[]{1, 1}, 1, 4));

        assertFalse(checkArray(new int[]{0, 0}, 1, 4));
    }

    @Test()
    public void changeArrayTest() {
        assertThrows(RuntimeException.class, () -> changeArray(new int[]{}, 4));

        assertThrows(RuntimeException.class, () -> {
            int[] array = {1, 2, 0, 0, 2, 3, 0, 1, 7};
            changeArray(array, 4);
        });

        int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] result = changeArray(array, 4);

        assertArrayEquals(new int[]{1, 7}, result);
    }
}