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
