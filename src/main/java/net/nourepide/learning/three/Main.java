package net.nourepide.learning.three;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ADDRESS = "/home/username/file.txt";

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

        // Enter to the chat last 100 lines
        final List<String> strings = history.lines().collect(Collectors.toList());

        // If size lesser than 100 - start from 0
        // If size larger than 100 - start from size - 100
        final int start = strings.size() < 100 ? 0 : strings.size() - 100;
        final int end = strings.size();

        IntStream.range(start, end)
                .mapToObj(strings::get)
                .forEach(System.out::println);

        // Initialisation complete
        isEnabled = true;
    }

    // Returns user name
    private static String getName() {
        System.out.println("Please enter your name");
        return getLine();
    }

    // Returns user input
    private static String getLine() {
        return scanner.nextLine();
    }

    // Write message to chat and file
    private static void writeMessage() throws IOException {
        String message = getLine();

        // Stop application if user wrote exit
        if (message.equals("exit")) {
            isEnabled = false;
            return;
        }

        writeMessageToChat(name, message);
        writeMessageToFile(name, message);
    }

    private static void writeMessageToChat(String name, String message) {
        System.out.println(name + ": " + message);
    }

    private static void writeMessageToFile(String name, String message) throws IOException {
        history = history + name + ": " + message + System.lineSeparator();
        Files.writeString(Paths.get(ADDRESS), history);
    }
}