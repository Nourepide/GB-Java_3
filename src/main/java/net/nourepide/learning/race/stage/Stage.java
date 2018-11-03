package net.nourepide.learning.race.stage;

import net.nourepide.learning.race.Application;
import net.nourepide.learning.race.Car;

public abstract class Stage {
    private final int length;
    private final String description;

    public Stage(String type, int length) {
        this.length = length;
        this.description = type + " " + length + " метров";
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public abstract void enter(Car car);

    protected void lastStage() {
        Application.countDownLatchEnd.countDown();
    }
}
