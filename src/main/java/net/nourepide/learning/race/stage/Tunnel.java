package net.nourepide.learning.race.stage;

import net.nourepide.learning.race.Application;
import net.nourepide.learning.race.Car;
import net.nourepide.learning.race.Utils;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore semaphore;

    public Tunnel(int length) {
        super("Тоннель", length);

        this.semaphore = new Semaphore(Application.CARS_COUNT / 2);
    }

    @Override
    public void enter(Car car) {
        Utils.printStageReady(car.getName(), getDescription());

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Utils.printStageStart(car.getName(), getDescription());
        Utils.sleep(getLength() / car.getSpeed() * 1000);
        Utils.printStageEnd(car.getName(), getDescription());

        semaphore.release();

        // It's last stage
        lastStage();
    }
}
