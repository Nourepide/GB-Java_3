package net.nourepide.learning.race.stage;

import net.nourepide.learning.race.Car;
import net.nourepide.learning.race.Utils;

public class Road extends Stage {
    public Road(int length) {
        super("Дорога", length);
    }

    @Override
    public void enter(Car car) {
        Utils.printStageStart(car.getName(), getDescription());

        Utils.sleep(getLength() / car.getSpeed() * 1000);

        Utils.printStageEnd(car.getName(), getDescription());
    }
}
