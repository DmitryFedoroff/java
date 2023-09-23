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
