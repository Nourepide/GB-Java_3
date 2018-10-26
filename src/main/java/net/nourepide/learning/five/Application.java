package net.nourepide.learning.five;

import net.nourepide.learning.five.stage.Road;
import net.nourepide.learning.five.stage.Tunnel;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Application {
    public static final int CARS_COUNT = 4;

    public static final CountDownLatch countDownLatchStart = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch countDownLatchEnd = new CountDownLatch(CARS_COUNT);

    private static final Car[] cars = new Car[CARS_COUNT];
    private static final Race race = new Race(new Road(60), new Tunnel(80));

    public static void main(String[] args) throws InterruptedException {
        Utils.printRushReady();

        // Set cars
        initialisation();

        // Start cars
        start();

        countDownLatchStart.await();
        Utils.printRushStart();

        countDownLatchEnd.await();
        Utils.printRushEnd();
    }

    /**
     * Create and setup cars and add to Car[]
     * Number of created cars equals length of array (By default CARS_COUNT)
     */
    private static void initialisation() {
        Arrays.setAll(cars, value -> getCar());
    }

    private static Car getCar() {
        final int speed = 20 + (int) (Math.random() * 10);
        return new Car(race, speed);
    }

    private static void start() {
        for (Car car : cars) new Thread(car).start();
    }
}
