package net.nourepide.learning.lessonTwo;


import net.nourepide.learning.lessonTwo.enity.Project;
import net.nourepide.learning.lessonTwo.service.ProjectService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Соединение с БД
    // Запрос логина и пароля
    public static void main(String[] args) throws IOException {
        final ProjectService projectService = new ProjectService();

//        Pair<String, String> user = getUser();
//        System.out.println(user.getFirst());
//        System.out.println(user.getSecond());
    }

    // Парсинг
    // Проверка и вывод в чат

    private static Pair<String, String> getUser() {
        final String name;
        final String password;

        final Scanner input = new Scanner(System.in);

        System.out.println("Please, enter your name");
        name = input.next();

        System.out.println("Please, enter your password");
        password = input.next();

        return new Pair<>(name, password);
    }
}
