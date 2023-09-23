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
