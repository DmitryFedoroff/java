package client;

import service.CustomerManagementService;
import interfaces.CustomerServiceInterface;
import models.Ticket;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * The main class of the client application that manages the user interface for logging in,
 * registering, and purchasing tickets.
 */
public class ApplicationStarter extends UserInputValidator {
    private CustomerServiceInterface customer;
    private int ticketRouteNumber;
    private Date ticketDate;

    public ApplicationStarter() {
        printMessageLine("Bus Ticket Purchasing Application");
    }

    /**
     * Method to launch the login/registration menu. Allows the user to log in or register.
     */
    public void runLoginRegisterMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Press 1 to log in");
            printMessageLine("Press 2 to register");
            printMessageLine("Press 0 to exit");
            System.out.print("Your choice > ");
            int choice = 0;
            try {
                choice = inputInt(0, 2);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            run = runLoginRegisterMenuChoiceLogic(choice);
        }
    }

    /**
     * Logic for choosing an action in the login/registration menu.
     *
     * @param choice user's choice
     * @return true if the menu should continue working; false if the user chose to exit
     */
    private boolean runLoginRegisterMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                login();
                if (customer.getUser() != null) {
                    runBuyingMenu();
                }
                break;
            case 2:
                register();
                if (customer != null) {
                    runBuyingMenu();
                }
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Method for logging in, including user authentication.
     */
    private void login() {
        printMessageLine("Login");
        System.out.print("Username: ");
        String userName = inputString();
        System.out.print("Password: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Logging in... ");
        customer = new CustomerManagementService();
        try {
            customer.setUser(UserAuthenticationService.authentication(customer.getUserProvider(), userName, passwordHash));
            printMessageLine("Successful");
        } catch (RuntimeException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method for registering a new user in the system.
     */
    private void register() {
        printMessageLine("Registration");
        System.out.print("Enter username: ");
        String userName = inputString();
        System.out.print("Enter password: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Repeat password: ");
        int passwordHash2 = inputString().hashCode();
        if (passwordHash != passwordHash2) {
            printMessageLine("Passwords do not match. Registration canceled.");
            return;
        }
        System.out.print("Enter card number: ");
        long cardNumber = inputLong(1L, 9999_9999_9999_9999L);
        System.out.print("Registering... ");
        customer = new CustomerManagementService();
        int id;
        try {
            id = customer.getUserProvider().createClient(userName, passwordHash, cardNumber);
            customer.setUser(UserAuthenticationService.authentication(customer.getUserProvider(), userName, passwordHash));
            printMessageLine("Successful. User " + customer.getUser().getUserName() + " with ID " + id + " added.");
        } catch (RuntimeException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method to launch the ticket purchasing menu, offering the user route and date selection options.
     */
    private void runBuyingMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Bus Ticket Purchasing Application. | User " + customer.getUser().getUserName() + " |");
            printMessageLine("Press 1 to choose a route number and view all tickets");
            printMessageLine("Press 0 to log out");
            System.out.print("Your choice > ");
            int choice = 0;
            try {
                choice = inputInt(0, 1);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            run = runBuyingMenuChoiceLogic(choice);
        }
    }

    /**
     * Logic for choosing an action in the ticket purchasing menu.
     *
     * @param choice user's choice
     * @return true if the menu should continue working; false if the user chose to exit
     */
    private boolean runBuyingMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                ticketRouteNumber = runSelectRouteMenu();
                if (ticketRouteNumber > 0) {
                    ticketDate = runSelectDate();
                    if (ticketDate != null) {
                        try {
                            customer.setSelectedTickets(customer.searchTicket(ticketDate, ticketRouteNumber));
                        } catch (RuntimeException ex) {
                            printMessageLine(ex.getMessage());
                            return true;
                        }
                        printAllTickets(customer.getSelectedTickets());
                        buyTicketMenu();
                        return true;
                    }
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Method to select the ticket route number.
     *
     * @return selected route number
     */
    private int runSelectRouteMenu() {
        printMessageLine("Select route number and date. | User " + customer.getUser().getUserName() + " |");
        System.out.print("Route number > ");
        int numRoute;
        try {
            numRoute = inputInt(1, 2);
            System.out.println();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return -1;
        }
        return numRoute;
    }

    /**
     * Method to select the ticket purchase date.
     *
     * @return selected date
     */
    private Date runSelectDate() {
        System.out.print("Date (format: YYYY-MM-DD) > ");
        Date date;
        try {
            date = inputDate();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return null;
        }
        return date;
    }

    /**
     * Method to print all available tickets.
     *
     * @param ticks list of tickets to print
     */
    private void printAllTickets(List<Ticket> ticks) {
        for (var t : ticks) {
            System.out.println(t.toString());
        }
    }

    /**
     * Method to launch the ticket purchase confirmation menu.
     */
    private void buyTicketMenu() {
        printMessageLine("Purchase confirmation. | User " + customer.getUser().getUserName() + " |");
        System.out.print("To purchase a ticket for route " + ticketRouteNumber + " on date " + ticketDate + " enter \"YES\" > ");
        String answer = inputString();
        buyTicketMenuConfirmLogic(answer);
    }

    /**
     * Logic for confirming ticket purchase.
     *
     * @param answer user's response to the confirmation request
     */
    private void buyTicketMenuConfirmLogic(String answer) {
        if (answer.equalsIgnoreCase("YES")) {
            LocalDate inputDate = ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            for (var t : customer.getSelectedTickets()) {
                LocalDate ticketDate = t.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (ticketDate.equals(inputDate) && t.getRouteNumber() == ticketRouteNumber && t.isValid()) {
                    boolean flag = false;
                    try {
                        flag = customer.buyTicket(t);
                    } catch (RuntimeException ex) {
                        printMessageLine(ex.getMessage());
                        return;
                    }
                    if (flag) {
                        printMessageLine("Ticket successfully purchased:\n" + t.toPrint());
                        return;
                    }
                }
            }
            printMessageLine("Failed to find a suitable ticket for purchase.");
        }
    }

    /**
     * Method to print a message with the addition of a separator line.
     *
     * @param message message to print
     */
    private void printMessageLine(String message) {
        System.out.println(message);
        System.out.println("=====================================================================================");
    }
}