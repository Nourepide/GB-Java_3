package net.nourepide.learning.race;

import java.util.stream.IntStream;

import static net.nourepide.learning.race.Application.countDownLatchStart;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;

    private final String name;
    private final Race race;
    private final int speed;

    public Car(Race race, int speed) {
        incrementCarsCount();

        this.name = "#" + CARS_COUNT;
        this.race = race;
        this.speed = speed;
    }

    private void incrementCarsCount() {
        CARS_COUNT += 1;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        Utils.printCarReady(getName());

        Utils.sleep(500 + (int) (Math.random() * 1000));

        Utils.printCarComplete(getName());

        /*
         * Suspend Car for waiting another cars
         * Resume if all cars are ready
         */
        try {
            countDownLatchStart.countDown();
            countDownLatchStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final int start = 0;
        final int end = race.getStages().size();

        IntStream
                .range(start, end)
                .forEach(value -> race.getStages().get(value).enter(this));
    }
}
