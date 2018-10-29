package net.nourepide.learning;

import net.nourepide.learning.six.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    public void checkArray() {
        {
            boolean result = Application.checkArray(new int[]{1, 4}, 1, 4);
            Assertions.assertTrue(result);
        }

        {
            boolean result = Application.checkArray(new int[]{4, 4}, 1, 4);
            Assertions.assertFalse(result);
        }

        {
            boolean result = Application.checkArray(new int[]{1, 1}, 1, 4);
            Assertions.assertFalse(result);
        }

        {
            boolean result = Application.checkArray(new int[]{0, 0}, 1, 4);
            Assertions.assertFalse(result);
        }
    }

    @Test()
    public void changeArray() {
        {
            Assertions.assertThrows(RuntimeException.class, () ->
                    Application.changeArray(new int[]{}, 4)
            );
        }

        {
            Assertions.assertThrows(RuntimeException.class, () -> {
                int[] array = {1, 2, 0, 0, 2, 3, 0, 1, 7};
                Application.changeArray(array, 4);
            });
        }

        {
            int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 7};
            int[] result = Application.changeArray(array, 4);

            Assertions.assertArrayEquals(new int[]{1, 7}, result);
        }
    }
}