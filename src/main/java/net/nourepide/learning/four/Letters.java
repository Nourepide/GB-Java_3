package net.nourepide.learning.four;

import java.util.stream.IntStream;

import static net.nourepide.learning.four.State.*;

public class Letters {
    /**
     * Print value in input and waiting for notifyAll
     * Range of cycle by default is five
     *
     * @param application is used as monitor for synchronization
     * @see State && toString()
     */
    private static void printState(Application application, State checkValue, State setValue) {
        synchronized (application) {
            IntStream.range(0, 5).forEach(value -> {
                while (application.getState() != checkValue) {
                    try {
                        application.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(checkValue);

                application.setState(setValue);
                application.notifyAll();
            });
        }
    }

    /**
     * Blank for implementation state
     * Have to use as thread or service
     *
     * @see State
     */
    private static class Letter implements Runnable {
        private final Application application;
        private final State checkValue;
        private final State setValue;

        public Letter(Application application, State checkValue, State setValue) {
            this.application = application;
            this.checkValue = checkValue;
            this.setValue = setValue;
        }

        @Override
        public void run() {
            printState(application, checkValue, setValue);
        }
    }

    public static class StateA extends Letter {
        public StateA(Application application) {
            super(application, A_REFERENCE, B_REFERENCE);
        }
    }

    public static class StateB extends Letter {
        public StateB(Application application) {
            super(application, B_REFERENCE, C_REFERENCE);
        }
    }

    public static class StateC extends Letter {
        public StateC(Application application) {
            super(application, C_REFERENCE, A_REFERENCE);
        }
    }
}
