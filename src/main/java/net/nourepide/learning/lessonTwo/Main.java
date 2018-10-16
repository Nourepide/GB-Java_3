package net.nourepide.learning.lessonTwo;

import net.nourepide.learning.lessonTwo.enity.Project;
import net.nourepide.learning.lessonTwo.service.ProjectService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Connection
        final ProjectService projectService = new ProjectService();

        while (true) {
            // Get users
            List<Project> users = projectService.findAll();

            // Get name and password
            User<String, String> user = getUser();

            boolean isSuccessful = false;

            for (Project project : users) {
                if (user.getName().equals(project.getName())
                        && user.getPassword().equals(project.getPassword())) {
                    isSuccessful = true;
                    break;
                }
            }

            if (isSuccessful) {
                System.out.println("User found");
                break;
            } else {
                System.out.println("User not found");
            }
        }
    }

    private static User<String, String> getUser() {
        final String name;
        final String password;

        final Scanner input = new Scanner(System.in);

        System.out.println("Please, enter your name");
        name = input.next();

        System.out.println("Please, enter your password");
        password = input.next();

        return new User<>(name, password);
    }
}
