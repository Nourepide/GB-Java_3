package net.nourepide.learning.testing;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Application {

    /**
     * Get array and return result of find two value
     *
     * @return false if value do not found
     */
    public static boolean checkArray(int[] array, int valueOne, int valueTwo) {
        boolean checkOne = false;
        boolean checkTwo = false;

        for (int value : array) {
            if (value == valueOne) checkOne = true;
            if (value == valueTwo) checkTwo = true;
        }

        return (checkOne && checkTwo);
    }

    /**
     * Get array and return new with values after value index
     *
     * @param value last value for copy array
     */
    public static int[] changeArray(int[] array, int value) {
        if (array == null || array.length == 0) throw new RuntimeException();

        final int checkIndex = checkIndex(array, value);
        final int difference = (array.length - 1) - checkIndex;

        final int[] newArray = new int[difference];

        System.arraycopy(array, array.length - difference, newArray, 0, newArray.length);

        return newArray;
    }

    /**
     * Get array and return index of last value
     *
     * @return index
     */
    private static int checkIndex(int[] array, int value) {
        final AtomicInteger indexValue = new AtomicInteger(-1);

        IntStream
                .range(0, array.length)
                .filter(i -> array[i] == value)
                .forEach(indexValue::set);

        if (indexValue.get() == -1) throw new RuntimeException();

        return indexValue.get();
    }
}
