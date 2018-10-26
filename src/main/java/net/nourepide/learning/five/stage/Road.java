package net.nourepide.learning.five.stage;

import net.nourepide.learning.five.Car;
import net.nourepide.learning.five.Utils;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.setDescription("Дорога " + length + " метров");
    }

    @Override
    public void go(Car car) {
        Utils.printStageStart(car.getName(), getDescription());

        Utils.sleep(length / car.getSpeed() * 1000);

        Utils.printStageEnd(car.getName(), getDescription());
    }
}
