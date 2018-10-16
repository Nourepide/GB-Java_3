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

        // For name change
        Project userProject = null;

        while (true) {
            // Get users
            final List<Project> users = projectService.findAll();

            // Get name and password
            final User<String, String> user = getUser();

            boolean isSuccessful = false;

            for (final Project project : users) {
                if (user.getName().equals(project.getName()) &&
                        user.getPassword().equals(project.getPassword())) {

                    isSuccessful = true;
                    userProject = project;
                    break;
                }
            }

            if (isSuccessful) {
                System.out.println("User found");

                // Exit from while
                break;
            } else {
                System.out.println("User not found");
                // New iteration
            }
        }

        // Change name
        final String name = getNewName();
        userProject.setName(name);

        // Push
        projectService.update(userProject);
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

    private static String getNewName() {
        System.out.println("Please, enter your new name");
        return new Scanner(System.in).next();
    }
}
