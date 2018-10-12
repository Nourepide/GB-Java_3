package net.nourepide.learning.lessonOne;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysUtils {
    static <T> void swap(T[] array, int indexOne, int indexTwo){
        // Yes ... without try/catch
        if (indexOne == indexTwo) {
            System.err.println("Index can't be identical");
            return;
        }

        if (indexOne < 0 || indexTwo < 0) {
            System.err.println("Index can't be less than zero");
            return;
        }

        if (array.length <= indexOne || array.length <= indexTwo) {
            System.err.println("Index can't be longer than array's length");
            return;
        }

        final T valueOne = array[indexOne];
        final T valueTwo = array[indexTwo];

        array[indexOne] = valueTwo;
        array[indexTwo] = valueOne;
    }

    public static <T> ArrayList<T> arrayConverter(T[] array) {
        // * Click * - Nice
        return new ArrayList<>(Arrays.asList(array));
    }
}
