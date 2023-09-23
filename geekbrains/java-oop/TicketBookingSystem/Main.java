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

package interfaces;

import models.Carrier;

/**
 * Interface for interacting with the carrier database.
 * Provides methods for reading information about carriers by their identifier.
 */
public interface CarrierDatabaseInterface {

    /**
     * Reads and returns information about the carrier by its unique identifier.
     *
     * @param id the unique identifier of the carrier.
     * @return the carrier object containing all the information about it, or null if no carrier with such ID is found.
     */
    Carrier read(int id);
}

package interfaces;

import service.UserManagementService;
import models.Ticket;
import models.User;

import java.util.Date;
import java.util.List;

/**
 * Interface for interacting with the client application.
 * Provides methods for working with tickets and users.
 */
public interface CustomerServiceInterface {

    /**
     * Gets the list of selected tickets.
     *
     * @return List of selected tickets.
     */
    List<Ticket> getSelectedTickets();

    /**
     * Sets the list of selected tickets.
     *
     * @param selectedTickets List of tickets to set.
     */
    void setSelectedTickets(List<Ticket> selectedTickets);

    /**
     * Gets the current user.
     *
     * @return The current user.
     */
    User getUser();

    /**
     * Sets the current user.
     *
     * @param client User to set.
     */
    void setUser(User client);

    /**
     * Gets the service provider for working with users.
     *
     * @return Service provider for working with users.
     */
    UserManagementService getUserProvider();

    /**
     * Buys a ticket.
     *
     * @param ticket Ticket to buy.
     * @return true if the purchase was successful, and false otherwise.
     * @throws RuntimeException if there was an error purchasing the ticket.
     */
    boolean buyTicket(Ticket ticket) throws RuntimeException;

    /**
     * Searches for tickets available for purchase by date and route number.
     *
     * @param date  Date to find tickets for.
     * @param route Route number to find tickets for.
     * @return List of tickets available for purchase.
     * @throws RuntimeException if there was an error searching for tickets.
     */
    List<Ticket> searchTicket(Date date, int route) throws RuntimeException;
}

package interfaces;

/**
 * Interface for interacting with the bank transactions database.
 * Provides methods for conducting transactions between bank cards.
 */
public interface PaymentTransactionInterface {

    /**
     * Conducts a transaction between two bank cards.
     *
     * @param payment  The payment amount in minimal monetary units (for example, pennies or cents).
     * @param cardFrom The sender's bank card number.
     * @param cardTo   The recipient's bank card number.
     * @return true if the transaction was successful, and false otherwise.
     */
    boolean transaction(int payment, long cardFrom, long cardTo);
}

package interfaces;

import models.Ticket;

import java.util.List;

/**
 * Interface for interacting with the ticket database.
 * Provides methods for creating, reading, updating, and deleting ticket records.
 */
public interface TicketDatabaseInterface {

    /**
     * Creates a new ticket in the database.
     *
     * @param ticket The ticket object to be created in the database.
     * @return true if the ticket was successfully created, and false otherwise.
     */
    boolean create(Ticket ticket);

    /**
     * Retrieves a list of all tickets by route number.
     *
     * @param routeNumber The route number to find the tickets for.
     * @return A list of tickets corresponding to the specified route number.
     */
    List<Ticket> readAll(int routeNumber);

    /**
     * Updates the ticket information in the database.
     *
     * @param ticket The ticket object with updated information.
     * @return true if the ticket information was successfully updated, and false otherwise.
     */
    boolean update(Ticket ticket);

    /**
     * Deletes a ticket from the database.
     *
     * @param ticket The ticket object to be deleted from the database.
     * @return true if the ticket was successfully deleted, and false otherwise.
     */
    boolean delete(Ticket ticket);
}

package interfaces;

import models.User;

import java.util.List;

/**
 * Interface for interacting with the user database.
 * Provides methods for creating, reading, updating, and deleting user records.
 */
public interface UserDatabaseInterface {

    /**
     * Creates a new user in the database.
     *
     * @param userName    The username, which must be unique.
     * @param passwordHash The hash of the user's password.
     * @param cardNumber   The user's card number.
     * @return The identifier of the created user.
     */
    int create(String userName, int passwordHash, long cardNumber);

    /**
     * Reads information about a user by their identifier.
     * This method is used only for testing and is not used in the application.
     *
     * @param id The user's identifier.
     * @return The user object or null if a user with such an identifier is not found.
     */
    User read(int id);

    /**
     * Reads information about a user by their username.
     *
     * @param userName The username.
     * @return The user object or null if a user with such a username is not found.
     */
    User read(String userName);

    /**
     * Reads information about all users in the database.
     * This method is used only for testing and is not used in the application.
     *
     * @return A list of all users.
     */
    List<User> readAll();

    /**
     * Updates information about a user in the database.
     * This method is used only for testing and is not used in the application.
     *
     * @param client The user object with updated information.
     * @return true if the update was successful, and false otherwise.
     */
    boolean update(User client);

    /**
     * Deletes a user from the database.
     * This method is used only for testing and is not used in the application.
     *
     * @param client The user object to be deleted.
     * @return true if the deletion was successful, and false otherwise.
     */
    boolean delete(User client);
}

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

package client;

import service.UserManagementService;
import models.User;

/**
 * Class responsible for user authentication in the system.
 * Contains methods for verifying the user-entered data (login and password hash)
 * against the data stored in the database.
 */
public class UserAuthenticationService {

    /**
     * Method for user authentication.
     * Searches for the user in the database by login and compares the hash of the entered password with the hash stored in the database.
     *
     * @param userManagementService service for working with user data
     * @param login user login
     * @param passHash user password hash
     * @return user object if authentication was successful
     * @throws RuntimeException if authentication failed (incorrect login or password)
     */
    public static User authentication(UserManagementService userManagementService, String login, int passHash) {
        var client = userManagementService.getClientByName(login);
        if (client.getHashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Authentication error: incorrect login or password");
        }
    }
}

package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Abstract class designed for validating user input data.
 * Contains methods for entering and checking various types of data: integers, long integers, strings, and dates.
 */
public abstract class UserInputValidator {

    /**
     * Method for inputting and validating an integer within a specified range.
     * The user enters a number that is checked for compliance with the specified range.
     *
     * @param minVariant the minimum allowable value
     * @param maxVariant the maximum allowable value
     * @return the integer entered by the user
     * @throws RuntimeException if an out-of-range value is entered or if it is not a number
     */
    protected int inputInt(int minVariant, int maxVariant) throws RuntimeException {
        int num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextInt();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("An invalid value has been entered. Please enter a number in the range from " + minVariant + " to " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Not a number entered. Please try again.");
        }
        return num;
    }

    /**
     * Method for inputting and validating a long integer within a specified range.
     * The user enters a number that is checked for compliance with the specified range.
     *
     * @param minVariant the minimum allowable value
     * @param maxVariant the maximum allowable value
     * @return the long integer entered by the user
     * @throws RuntimeException if an out-of-range value is entered or if it is not a number
     */
    protected long inputLong(long minVariant, long maxVariant) throws RuntimeException {
        long num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextLong();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("An invalid value has been entered. Please enter a number in the range from " + minVariant + " to " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Not a number entered. Please try again.");
        }
        return num;
    }

    /**
     * Method for inputting a string followed by validation for an empty string.
     * The user enters a string that is checked for the absence of text (only spaces or an empty string).
     *
     * @return the string entered by the user
     * @throws RuntimeException if an empty string is entered or a string containing only spaces
     */
    protected String inputString() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.trim().isEmpty()) {
            throw new RuntimeException("The string cannot be empty. Please try again.");
        }
        return str;
    }

    /**
     * Method for inputting a date followed by validation.
     * The user enters a date in the "yyyy-MM-dd" format, which is checked for compliance with this format.
     *
     * @return the date entered by the user
     * @throws RuntimeException if an incorrect date is entered
     */
    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ft.setLenient(false); // Setting strict date format checking
        Scanner in = new Scanner(System.in);
        String str;
        Date date;
        try {
            str = in.nextLine();
            date = ft.parse(str);
        } catch (ParseException ex) {
            throw new RuntimeException("An incorrect date has been entered. Please enter the date in the yyyy-MM-dd format.");
        }
        return date;
    }
}

package models;

/**
 * Class representing a bank account model.
 * Stores information about the card number and the account balance.
 */
public class BankAccount {

    private long card; // Card number
    private static long oldCard; // Previous card number
    private int balance; // Account balance

    /**
     * Default constructor, initializing the initial balance and setting the card number.
     */
    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    /**
     * Method to set the account balance.
     *
     * @param balance new balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Method to set the card number.
     *
     * @param card new card number
     */
    public void setCard(long card) {
        this.card = card;
    }

    /**
     * Method to get the card number.
     *
     * @return card number
     */
    public long getCard() {
        return card;
    }

    /**
     * Method to get the account balance.
     *
     * @return account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Overridden toString method to represent the object as a string.
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}

package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a carrier model.
 * Stores information about the carrier's identifier, its card number, and the zones in which it operates.
 */
public class Carrier {

    private int id; // Carrier identifier
    private long cardNumber; // Carrier card number
    private List<Integer> zones; // List of zones where the carrier operates

    /**
     * Class constructor initializing the id and cardNumber fields.
     * Also initializes the list of zones, adding zones 0 and 1 to it.
     *
     * @param id         carrier identifier
     * @param cardNumber carrier card number
     */
    public Carrier(int id, long cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;

        zones = new ArrayList<>();
        zones.add(0);
        zones.add(1);
    }

    /**
     * Method to get the carrier card number.
     *
     * @return carrier card number
     */
    public long getCardNumber() {
        return cardNumber;
    }

    /**
     * Method to get the carrier identifier.
     *
     * @return carrier identifier
     */
    public int getId() {
        return id;
    }
}

package models;

import java.util.Date;

/**
 * Class representing a ticket model.
 * Contains information about the route, seat, price, travel date, and ticket status (valid or not).
 */
public class Ticket {

    // Class fields
    private long id; // Unique ticket identifier
    private int zoneStart; // Starting zone of the route
    private int zoneStop; // Ending zone of the route
    private int routeNumber; // Route number
    private int place; // Seat number
    private int price; // Ticket price
    private Date date; // Travel date
    private boolean isValid; // Ticket status (valid or not)

    /**
     * Ticket class constructor.
     *
     * @param routeNumber Route number
     * @param place       Seat number
     * @param price       Ticket price
     * @param date        Travel date
     * @param isValid     Ticket status (valid or not)
     */
    public Ticket(int routeNumber, int place, int price, Date date, boolean isValid) {
        this.routeNumber = routeNumber;
        this.place = place;
        this.price = price;
        this.date = date;
        this.isValid = isValid;
    }

    // Getters and setters for class fields

    public void setZoneStart(int zoneStart) {
        this.zoneStart = zoneStart;
    }

    public void setZoneStop(int zoneStop) {
        this.zoneStop = zoneStop;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * Overridden toString method to provide a string representation of the ticket object.
     * Typically used for logging and debugging.
     *
     * @return string representation of the ticket object
     */
    @Override
    public String toString() {
        return "Ticket" +
                " Route number: " + routeNumber +
                ", Seat: " + place +
                ", Price: " + price + " rub." +
                ", Date: " + date +
                ", Status: " + (isValid ? "Available" : "Occupied");
    }

    /**
     * Method to form a string representation of the ticket intended for printing or displaying to the user.
     * Provides a more detailed and readable representation of the ticket information.
     *
     * @return string representation of the ticket for printing
     */
    public String toPrint() {
        return "Route number: " + routeNumber +
                "\nSeat: " + place +
                "\nPrice: " + price + " rub." +
                "\nDate: " + date;
    }

    // Overridden hashCode and equals methods for correct operation with collections

    @Override
    public int hashCode() {
        return date.hashCode() ^ (routeNumber + place + price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.equals((Ticket) obj);
    }

    public boolean equals(Ticket ticket) {
        return ticket != null
                && ticket.getRouteNumber() == this.routeNumber
                && ticket.getPlace() == this.place
                && ticket.getPrice() == this.price
                && ticket.getDate().equals(this.date)
                && ticket.hashCode() == this.hashCode();
    }
}

package models;

import java.util.Objects;

/**
 * Class representing a user model.
 * Stores information about the user's ID, their name, hashed password, and bank card number.
 */
public class User {

    private int id; // Unique user identifier
    private String userName; // User name
    private int hashPassword; // User password hash
    private long cardNumber; // User's bank card number

    /**
     * Constructor for creating a user object with specified parameters.
     *
     * @param id           unique user identifier
     * @param userName     user name
     * @param hashPassword user password hash
     * @param cardNumber   user's bank card number
     */
    public User(int id, String userName, int hashPassword, long cardNumber) {
        this.id = id;
        this.userName = userName;
        this.hashPassword = hashPassword;
        this.cardNumber = cardNumber;
    }

    // Getters for class fields with corresponding comments

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getHashPassword() {
        return hashPassword;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    // Overridden toString method with card number formatting

    @Override
    public String toString() {
        return "Client { " +
                "id= " + id +
                ", userName= " + userName +
                ", cardNumber= " + (String.format("%016d", cardNumber)) +
                " }";
    }

    // Overridden equals and hashCode methods for comparing objects and obtaining the object's hash code

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.equals(user);
    }

    public boolean equals(User user) {
        return id == user.id && hashPassword == user.hashPassword && cardNumber == user.cardNumber && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, hashPassword, cardNumber);
    }
}

package repository;

import interfaces.CarrierDatabaseInterface;
import models.Carrier;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class simulating the operation with the carrier database.
 * Implements the CarrierDatabaseInterface interface.
 * Uses the Singleton pattern to create a single instance of the class.
 */
public class CarrierRepository implements CarrierDatabaseInterface {
    private static CarrierRepository carrierRepository; // The single instance of the class
    private List<Carrier> carriers; // List of carriers

    /**
     * Private constructor initializing the list of carriers.
     * Adds one carrier with ID 1 to the list.
     */
    private CarrierRepository() {
        carriers = new ArrayList<>();
        carriers.add(new Carrier(1, 1));
    }

    /**
     * Static method returning the single instance of the class.
     * If the instance was not created earlier, it creates a new one.
     *
     * @return the single instance of the CarrierRepository class
     */
    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    /**
     * Method to read carrier information by its ID.
     * Iterates over the list of carriers and returns the carrier with the specified ID.
     * If the carrier is not found, it throws an exception with an error message.
     *
     * @param id unique identifier of the carrier
     * @return carrier object
     * @throws RuntimeException if the carrier with the specified ID is not found
     */
    @Override
    public Carrier read(int id) throws RuntimeException {
        for (var carrier : carriers) {
            if (carrier.getId() == id) {
                return carrier;
            }
        }
        throw new RuntimeException("Carrier with the specified ID not found");
    }
}

package repository;

import interfaces.PaymentTransactionInterface;
import models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class simulating the operation with the bank database.
 * Implements the PaymentTransactionInterface interface.
 * Uses the Singleton pattern to create a single instance of the class.
 */
public class CashRepository implements PaymentTransactionInterface {
    private static CashRepository cashRepository; // The single instance of the class
    private List<BankAccount> clients; // List of client bank accounts

    /**
     * Method to get the list of client bank accounts.
     *
     * @return list of client bank accounts
     */
    public List<BankAccount> getClients() {
        return clients;
    }

    /**
     * Private constructor initializing the list of client bank accounts.
     * Adds five bank accounts with an initial balance to the list.
     */
    private CashRepository() {
        clients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            clients.add(new BankAccount());
        }
    }

    /**
     * Static method returning the single instance of the class.
     * If the instance was not created earlier, it creates a new one.
     *
     * @return the single instance of the CashRepository class
     */
    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    /**
     * Method to conduct a transaction between two bank accounts.
     * Checks the existence of accounts and sufficient funds to conduct the transaction.
     * In case of successful validation, conducts the transaction, changing the account balances.
     *
     * @param payment     payment amount
     * @param cardFrom    sender's card number
     * @param carrierCard recipient's card number
     * @return true, if the transaction was successful, otherwise false
     * @throws RuntimeException if validation failed, with a message indicating the reason
     */
    @Override
    public boolean transaction(int payment, long cardFrom, long carrierCard) throws RuntimeException {
        BankAccount from = null;
        BankAccount to = null;

        // Searching for the sender's and recipient's bank accounts
        for (var client : clients) {
            if (client.getCard() == cardFrom) {
                from = client;
            }
            if (client.getCard() == carrierCard) {
                to = client;
            }
        }

        // Checking the existence of accounts
        if (from == null) {
            throw new RuntimeException("Account for withdrawal not found.");
        }
        if (to == null) {
            throw new RuntimeException("Account for deposit not found.");
        }

        // Checking the sender's account balance
        if (from.getBalance() - payment < 0) {
            throw new RuntimeException("Insufficient funds in the account.");
        }

        // Checking the recipient's account balance
        if (to.getBalance() > Integer.MAX_VALUE - payment) {
            throw new RuntimeException("Too large amount to be credited to the account.");
        }

        // Conducting the transaction with updating account balances
        try {
        } finally {
            clients.remove(from);
            clients.remove(to);
            from.setBalance(from.getBalance() - payment);
            to.setBalance(to.getBalance() + payment);
            clients.add(from);
            clients.add(to);
        }
        return true;
    }
}

package repository;

import interfaces.TicketDatabaseInterface;
import models.Ticket;

import java.util.*;

/**
 * Repository class simulating the operation with the ticket database.
 * Implements the TicketDatabaseInterface interface.
 * Uses the Singleton pattern to create a single instance of the class.
 */
public class TicketRepository implements TicketDatabaseInterface {
    private static TicketRepository ticketRepository; // The single instance of the class
    private List<Ticket> tickets; // List of tickets

    /**
     * Private constructor initializing the list of tickets.
     * Generates tickets for two routes using the generateTickets method.
     */
    private TicketRepository() {
        tickets = new ArrayList<>();
        Date date = new Date();
        generateTickets(1, 6, 10, date);
        generateTickets(2, 4, 15, date);
    }

    /**
     * Static method returning the single instance of the class.
     * If the instance was not created earlier, it creates a new one.
     *
     * @return the single instance of the TicketRepository class
     */
    public static TicketRepository getTicketRepository() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    /**
     * Method to create a new ticket.
     * Not used in the current implementation.
     *
     * @param ticket ticket object
     * @return true, confirming the successful creation of the ticket
     */
    @Override
    public boolean create(Ticket ticket) {
        tickets.add(ticket);
        return true;
    }

    /**
     * Method to read all available tickets by route number.
     *
     * @param routeNumber route number
     * @return list of available tickets
     * @throws RuntimeException if tickets are not found, with a message indicating the reason
     */
    @Override
    public List<Ticket> readAll(int routeNumber) throws RuntimeException {
        List<Ticket> routeTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getRouteNumber() == routeNumber && ticket.isValid()) {
                routeTickets.add(ticket);
            }
        }
        if (routeTickets.isEmpty()) {
            throw new RuntimeException("No tickets available for this bus.");
        }
        return tickets;
    }

    /**
     * Method to update ticket information.
     *
     * @param ticket ticket object with updated information
     * @return true, if the update was successful, otherwise false
     */
    @Override
    public boolean update(Ticket ticket) {
        for (Ticket tick : tickets) {
            if (tick.equals(ticket)) {
                tickets.remove(tick);
                tickets.add(ticket);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to delete a ticket.
     * Not used in the current implementation.
     *
     * @param ticket ticket object to be deleted
     * @return true, if the ticket was successfully deleted, otherwise false
     */
    @Override
    public boolean delete(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            return true;
        }
        return false;
    }

    /**
     * Private method for generating tickets.
     * Creates the specified number of tickets for the route with the given parameters.
     *
     * @param routeNumber route number
     * @param countPlaces number of places
     * @param price       ticket price
     * @param date        departure date
     */
    private void generateTickets(int routeNumber, int countPlaces, int price, Date date) {
        for (int i = 1; i <= countPlaces; i++) {
            tickets.add(new Ticket(routeNumber, i, price, date, true));
        }
    }
}

package repository;

import interfaces.UserDatabaseInterface;
import models.User;
import models.BankAccount;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to simulate user database operations.
 * Implements the UserDatabaseInterface.
 */
public class UserRepository implements UserDatabaseInterface {
    private static UserRepository clientRepository;
    private List<User> clients;

    /**
     * Private constructor ensuring singleton for the repository.
     * Initializes the client list with test data.
     */
    private UserRepository() {
        // Simulating database operation with clients
        clients = new ArrayList<>();
        clients.add(new User(1, "Client 1", "1111".hashCode(), 2));
        clients.add(new User(2, "Client 2", "2222".hashCode(), 3));
        clients.add(new User(3, "Client 3", "3333".hashCode(), 4));
        clients.add(new User(4, "Client 4", "4444".hashCode(), 5));
    }

    /**
     * Static method to get the repository instance (singleton).
     *
     * @return UserRepository instance
     */
    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (var currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                throw new RuntimeException("A client with this ID already exists");
            }
        }
        clients.add(client);

        // Creating a new bank account for the new user
        CashRepository cashRepository = CashRepository.getCashRepository();
        BankAccount newAccount = new BankAccount();
        newAccount.setCard(cardNumber); // Setting the card number
        newAccount.setBalance(1000); // Setting the initial balance, for instance, 1000
        cashRepository.getClients().add(newAccount);

        return client.getId();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (var client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new RuntimeException("Client with this ID not found");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (var client : clients) {
            var clientName = client.getUserName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("Client with this name not found");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("Client list is empty");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        User tempClient = null;
        for (User currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}

package service;

import interfaces.CustomerServiceInterface;
import models.Ticket;
import models.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class implementing the main logic of ticket purchasing.
 * Implements the CustomerServiceInterface.
 */
public class CustomerManagementService implements CustomerServiceInterface {
    private TicketManagementService ticketManagementService;
    private PaymentProcessingService paymentProcessingService;
    private UserManagementService userManagementService;
    private User client;
    private List<Ticket> selectedTickets;

    /**
     * Class constructor initializing services for working with tickets, payments, and users.
     */
    public CustomerManagementService() {
        this.paymentProcessingService = new PaymentProcessingService();
        this.ticketManagementService = new TicketManagementService();
        this.userManagementService = new UserManagementService();
    }

    @Override
    public List<Ticket> getSelectedTickets() {
        return selectedTickets;
    }

    @Override
    public void setSelectedTickets(List<Ticket> selectedTickets) {
        this.selectedTickets = selectedTickets;
    }

    @Override
    public UserManagementService getUserProvider() {
        return userManagementService;
    }

    @Override
    public User getUser() {
        return client;
    }

    @Override
    public void setUser(User client) {
        this.client = client;
    }

    @Override
    public boolean buyTicket(Ticket ticket) throws RuntimeException {
        // Precondition check: the ticket and the client should not be null
        if (ticket == null || client == null) {
            throw new IllegalArgumentException("Ticket or client cannot be null");
        }

        boolean flag;
        paymentProcessingService.authorization(client);
        flag = paymentProcessingService.buy(ticket);
        if (flag) {
            flag = ticketManagementService.updateTicketStatus(ticket);
        }

        // Postcondition check: the ticket should be successfully purchased
        if (!flag) {
            throw new RuntimeException("Failed to buy the ticket");
        }
        return flag;
    }

    @Override
    public List<Ticket> searchTicket(Date date, int route) throws RuntimeException {
        // Precondition check: the date should not be null and the route number should be positive
        if (date == null || route <= 0) {
            throw new IllegalArgumentException("Date cannot be null and route number must be positive");
        }

        List<Ticket> result = new ArrayList<>();
        var list = ticketManagementService.getTickets(route);

        LocalDate inputDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (Ticket ticket : list) {
            LocalDate ticketDate = ticket.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (ticketDate.equals(inputDate)) {
                result.add(ticket);
            }
        }

        // Postcondition check: a list of tickets should be returned
        if (result.isEmpty()) {
            throw new RuntimeException("No tickets available for this date");
        }
        return result;
    }
}

package service;

import interfaces.CarrierDatabaseInterface;
import interfaces.PaymentTransactionInterface;
import models.Carrier;
import models.Ticket;
import models.User;
import repository.CarrierRepository;
import repository.CashRepository;

/**
 * Provider class for interaction with the bank and the carrier database.
 * Responsible for payment authorization and transaction execution.
 */
public class PaymentProcessingService {

    private long cardNumber;
    private boolean isAuthorized = false;
    private CarrierDatabaseInterface carrierRepository;
    private PaymentTransactionInterface cashRepository;

    /**
     * Class constructor initializing repositories for working with carriers and the cash register.
     * Implements the Singleton pattern for repositories.
     */
    public PaymentProcessingService() {
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Method for buying a ticket. Checks if authorization has been carried out, and if so,
     * carries out the ticket purchase transaction.
     *
     * @param ticket the ticket to be purchased
     * @return true if the purchase was successful, otherwise false
     * @throws RuntimeException in case of an error during ticket purchase
     */
    public boolean buy(Ticket ticket) {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
        }
        return false;
    }

    /**
     * Method for user authorization. In the current implementation, it simply saves the user's card number
     * and sets the authorization flag to true.
     *
     * @param client the user attempting to authorize
     */
    public void authorization(User client) {
        cardNumber = client.getCardNumber();
        isAuthorized = true;
    }
}

package service;

import interfaces.TicketDatabaseInterface;
import models.Ticket;
import repository.TicketRepository;

import java.util.List;

/**
 * Provider class for working with the ticket database.
 * Responsible for retrieving ticket information and updating ticket statuses.
 */
public class TicketManagementService {

    private TicketDatabaseInterface ticketRepo;

    /**
     * Class constructor initializing the repository for working with tickets.
     * Implements the Singleton pattern for the ticket repository.
     */
    public TicketManagementService() {
        this.ticketRepo = TicketRepository.getTicketRepository();
    }

    /**
     * Method to get a list of tickets by route number.
     * Checks the correctness of the input data and returns a list of available tickets.
     *
     * @param routeNumber the route number
     * @return a list of tickets
     * @throws RuntimeException if tickets are not found or an incorrect route number is entered
     */
    public List<Ticket> getTickets(int routeNumber) throws RuntimeException {
        if (routeNumber <= 0) {
            throw new IllegalArgumentException("Route number must be positive");
        }

        List<Ticket> tickets = ticketRepo.readAll(routeNumber);

        if (tickets.isEmpty()) {
            throw new RuntimeException("Tickets not found");
        }
        return tickets;
    }

    /**
     * Method to update the ticket status.
     * Checks the correctness of the input data and updates the ticket status in the database.
     *
     * @param ticket the ticket whose status needs to be updated
     * @return true if the status was successfully updated, otherwise false
     * @throws RuntimeException if the update failed or the ticket is incorrect
     */
    public boolean updateTicketStatus(Ticket ticket) throws RuntimeException {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        ticket.setValid(false);
        boolean result = ticketRepo.update(ticket);

        if (!result) {
            throw new RuntimeException("Failed to update ticket status");
        }
        return result;
    }
}

package service;

import interfaces.UserDatabaseInterface;
import models.User;
import repository.UserRepository;

import java.util.List;

/**
 * Provider class for working with the client database.
 * Responsible for creating new clients and retrieving information about existing clients.
 */
public class UserManagementService {
    private UserDatabaseInterface clientRepository;

    /**
     * Class constructor initializing the repository for working with clients.
     * Implements the Singleton pattern for the client repository.
     */
    public UserManagementService() {
        this.clientRepository = UserRepository.getClientRepository();
    }

    /**
     * Method for creating a new client in the database.
     * Checks the correctness of the input data and creates a new record in the database.
     *
     * @param userName     client name
     * @param passwordHash password hash
     * @param cardNumber   bank card number
     * @return ID of the new client in the database
     * @throws RuntimeException if creating a new client failed
     */
    public int createClient(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clientRepository.create(userName, passwordHash, cardNumber);
        return id;
    }

    /**
     * Method to find a client by name.
     * Checks the correctness of the input data and returns information about the client.
     *
     * @param userName client name
     * @return client object
     * @throws RuntimeException if the client with the specified name is not found
     */
    public User getClientByName(String userName) throws RuntimeException {
        var client = clientRepository.read(userName);
        return client;
    }

    /**
     * Method to get a list of all clients.
     * Used for administration and system testing.
     *
     * @return a list of all clients
     * @throws RuntimeException if it is not possible to get a list of clients
     */
    public List<User> getAllClients() throws RuntimeException {
        var clients = clientRepository.readAll();
        return clients;
    }
}

