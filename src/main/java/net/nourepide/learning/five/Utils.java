package net.nourepide.learning.five;

public class Utils {
    /**
     * Utils Thread.sleep for encapsulation try/catch
     *
     * @param value takes time in milliseconds for thread sleep
     * @see Thread
     */
    public static void sleep(int value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printRushReady() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!");
    }

    public static void printRushStart() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!");
    }

    public static void printRushEnd() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!");
    }

    public static void printCarReady(String name) {
        System.out.println(name + "готовится");
    }

    public static void printCarComplete(String name) {
        System.out.println(name + " готов");
    }

    public static void printStageReady(String name, String description) {
        System.out.println(name + "готовится к этапу: " + description);
    }

    public static void printStageStart(String name, String description) {
        System.out.println(name + "начал этап: " + description);
    }

    public static void printStageEnd(String name, String description) {
        System.out.println(name + "закончил этап: " + description);
    }
}
