package net.nourepide.learning.five.stage;

import net.nourepide.learning.five.Application;
import net.nourepide.learning.five.Car;
import net.nourepide.learning.five.Utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel extends Stage {
    ReentrantLock reentrantLock;
    Semaphore semaphore;

    public Tunnel() {
        this.reentrantLock = new ReentrantLock();
        this.semaphore = new Semaphore(Application.CARS_COUNT / 2);
        this.length = 80;
        this.setDescription("Тоннель " + length + " метров");
    }

    @Override
    public void go(Car car) {
        Utils.printStageReady(car.getName(), getDescription());

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Utils.printStageStart(car.getName(), getDescription());
        Utils.sleep(length / car.getSpeed() * 1000);
        Utils.printStageEnd(car.getName(), getDescription());

        semaphore.release();

        // It's last stage
        lastStage();
    }
}
