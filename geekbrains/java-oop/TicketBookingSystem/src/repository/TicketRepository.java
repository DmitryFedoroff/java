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
