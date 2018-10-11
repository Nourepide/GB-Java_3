package net.nourepide.learning.lesson_1.additional;

import net.nourepide.learning.lesson_1.additional.fruit.Apple;
import net.nourepide.learning.lesson_1.additional.fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Apple> boxApples = new Box<>(
                new Apple(),
                new Apple(),
                new Apple()
        );

        Box<Orange> boxOranges = new Box<>(
                new Orange(),
                new Orange(),
                new Orange()
        );

        // Don't work
        // boxApples.add(new Orange());

        // 3.0
        System.out.println(boxApples.getWeight());

        // 4.5
        System.out.println(boxOranges.getWeight());

        // 3.0 == 4.5 -> false
        System.out.println(boxApples.compare(boxOranges));


        // Fill
        Box<Apple> newBoxApples = new Box<>(
                new Apple(),
                new Apple()
        );

        boxApples.fill(newBoxApples);

        // 5.0
        System.out.println(boxApples.getWeight());
    }
}
