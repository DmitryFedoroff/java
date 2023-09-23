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
