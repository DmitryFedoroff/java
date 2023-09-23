package service;

import interfaces.UserDatabaseInterface;
import models.User;
import repository.UserRepository;

import java.util.List;

/**
 * Provider class for working with the client database.
 * Responsible for creating new clients and retrieving information about existing clients.
 */
public class UserManagementService {
    private UserDatabaseInterface clientRepository;

    /**
     * Class constructor initializing the repository for working with clients.
     * Implements the Singleton pattern for the client repository.
     */
    public UserManagementService() {
        this.clientRepository = UserRepository.getClientRepository();
    }

    /**
     * Method for creating a new client in the database.
     * Checks the correctness of the input data and creates a new record in the database.
     *
     * @param userName     client name
     * @param passwordHash password hash
     * @param cardNumber   bank card number
     * @return ID of the new client in the database
     * @throws RuntimeException if creating a new client failed
     */
    public int createClient(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clientRepository.create(userName, passwordHash, cardNumber);
        return id;
    }

    /**
     * Method to find a client by name.
     * Checks the correctness of the input data and returns information about the client.
     *
     * @param userName client name
     * @return client object
     * @throws RuntimeException if the client with the specified name is not found
     */
    public User getClientByName(String userName) throws RuntimeException {
        var client = clientRepository.read(userName);
        return client;
    }

    /**
     * Method to get a list of all clients.
     * Used for administration and system testing.
     *
     * @return a list of all clients
     * @throws RuntimeException if it is not possible to get a list of clients
     */
    public List<User> getAllClients() throws RuntimeException {
        var clients = clientRepository.readAll();
        return clients;
    }
}
