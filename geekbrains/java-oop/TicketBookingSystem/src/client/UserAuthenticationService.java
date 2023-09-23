package client;

import service.UserManagementService;
import models.User;

/**
 * Class responsible for user authentication in the system.
 * Contains methods for verifying the user-entered data (login and password hash)
 * against the data stored in the database.
 */
public class UserAuthenticationService {

    /**
     * Method for user authentication.
     * Searches for the user in the database by login and compares the hash of the entered password with the hash stored in the database.
     *
     * @param userManagementService service for working with user data
     * @param login user login
     * @param passHash user password hash
     * @return user object if authentication was successful
     * @throws RuntimeException if authentication failed (incorrect login or password)
     */
    public static User authentication(UserManagementService userManagementService, String login, int passHash) {
        var client = userManagementService.getClientByName(login);
        if (client.getHashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Authentication error: incorrect login or password");
        }
    }
}
