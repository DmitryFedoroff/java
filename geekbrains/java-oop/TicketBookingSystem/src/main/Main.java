package main;

import client.ApplicationStarter;

/**
 * The main class of the application, responsible for launching the program.
 * This class contains the main method, which is the entry point to the application.
 */
public class Main {
    /**
     * The main method, which is the entry point to the application.
     * In this method, an instance of the ApplicationStarter class is created and the runLoginRegisterMenu method is called,
     * which launches the login and registration menu.
     *
     * @param args command line arguments. In the current version of the program, command line arguments are not used.
     */
    public static void main(String[] args) {
        // Creating an instance of the ApplicationStarter class, which is responsible for launching the main menu of the application
        ApplicationStarter applicationStarter = new ApplicationStarter();

        // Launching the login and registration menu, where the user can log in or register
        applicationStarter.runLoginRegisterMenu();
    }
}
