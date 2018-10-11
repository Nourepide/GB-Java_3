package net.nourepide.learning.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1
        Integer[] intArray = {0, 1};
        ArraysUtils.swap(intArray, 0, 1);
        System.out.println(Arrays.toString(intArray));

        // Task 2
        ArrayList<Integer> intArrayList = ArraysUtils.arrayConverter(intArray);
        System.out.println(Arrays.toString(intArrayList.toArray()));
    }
}
