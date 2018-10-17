package net.nourepide.learning.two;

import net.nourepide.learning.two.enity.Users;
import net.nourepide.learning.two.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Connection
        final UserService userService = new UserService();
        Users user = authorization(userService);

        if (user != null) {
            System.out.println("User found");
        } else {
            System.out.println("User not found");
            return;
        }

        // Change name
        user.setName(getName());

        // Push
        userService.update(user);
    }

    private static Data<String, String> getUser() {
        final String name;
        final String password;

        final Scanner input = new Scanner(System.in);

        System.out.println("Please, enter your name");
        name = input.next();

        System.out.println("Please, enter your password");
        password = input.next();

        return new Data<>(name, password);
    }

    private static Users authorization(UserService userService) {
        // Get users
        final List<Users> users = userService.findAll();

        // Get name and password
        final Data<String, String> user = getUser();


        for (final Users project : users) {
            boolean equalsName = user.getFirst().equals(project.getName());
            boolean equalsPassword = user.getSecond().equals(project.getPassword());

            if (equalsName && equalsPassword) {
                return project;
            }
        }

        return null;
    }

    private static String getName() {
        System.out.println("Please, enter your new name");
        return new Scanner(System.in).next();
    }
}
