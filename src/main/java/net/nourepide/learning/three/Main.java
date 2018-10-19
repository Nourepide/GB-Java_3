package net.nourepide.learning.three;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ADDRESS = "/home/nourepide/test.txt";

    private static String name;
    private static String history;
    private static boolean isEnabled;

    public static void main(String[] args) throws IOException {
        initialisation();

        while (isEnabled) {
            writeMessage();
        }
    }

    private static void initialisation() throws IOException {
        // Get user name
        name = getName();

        // Read history file and save it
        history = Files.readString(Paths.get(ADDRESS));

        // Reverse and enter to the chat first 100 lines
        final List<String> strings = Files.readAllLines(Paths.get(ADDRESS));
        Collections.reverse(strings);

        int iterator = (strings.size() < 100) ? strings.size() -1 : 100;

        for (; iterator >= 0 ; iterator--) {
            System.out.println(strings.get(iterator));
        }

        // history.lines().limit(100).forEach(System.out::println);
        //                 ~~~~^~~~~

        isEnabled = true;
    }

    private static String getName() {
        System.out.println("Please enter your name");
        return getLine();
    }

    private static String getLine() {
        return scanner.nextLine();
    }

    private static void writeMessageToChat(String name, String message) {
        System.out.println(name + ": " + message);
    }

    private static void writeMessageToFile(String name, String message) throws IOException {
        history = history + name + ": " + message + System.lineSeparator();
        Files.writeString(Paths.get(ADDRESS), history);
    }

    private static void writeMessage() throws IOException {
        String message = getLine();

        if (message.equals("exit")) {
            isEnabled = false;
            return;
        }

        writeMessageToChat(name, message);
        writeMessageToFile(name, message);
    }
}
