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
