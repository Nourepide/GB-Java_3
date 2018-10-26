package net.nourepide.learning.five.stage;

import net.nourepide.learning.five.Application;
import net.nourepide.learning.five.Car;

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
