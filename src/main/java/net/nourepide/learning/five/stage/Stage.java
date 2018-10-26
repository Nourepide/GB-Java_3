package net.nourepide.learning.five.stage;

import net.nourepide.learning.five.Application;
import net.nourepide.learning.five.Car;

public abstract class Stage {
    protected int length;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void go(Car car);

    protected void lastStage() {
        Application.countDownLatchEnd.countDown();
    }
}
