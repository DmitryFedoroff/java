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
