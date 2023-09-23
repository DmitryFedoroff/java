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
