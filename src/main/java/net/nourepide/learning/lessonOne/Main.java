package net.nourepide.learning.lessonOne;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1
        final Integer[] intArray = {0, 1};
        ArraysUtils.swap(intArray, 0, 1);
        System.out.println(Arrays.toString(intArray));

        // Task 2
        final ArrayList<Integer> intArrayList = ArraysUtils.arrayConverter(intArray);
        System.out.println(Arrays.toString(intArrayList.toArray()));
    }
}
