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
