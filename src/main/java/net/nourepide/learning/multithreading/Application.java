package net.nourepide.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    /**
     * Is used for management wait() && notifyAll()
     * Initializing with first value or specified in attribute of constructor
     *
     * @see Application()
     * @see Application(State)
     */
    private State state;

    public Application() {
        this.state = State.A_REFERENCE;
    }

    public Application(State state) {
        this.state = state;
    }

    public static void main(String[] args) {
        final Application application = new Application();
        final ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Letters.StateA(application));
        executorService.execute(new Letters.StateB(application));
        executorService.execute(new Letters.StateC(application));

        executorService.shutdown();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
