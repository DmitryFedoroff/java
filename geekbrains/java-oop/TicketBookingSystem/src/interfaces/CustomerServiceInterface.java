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
