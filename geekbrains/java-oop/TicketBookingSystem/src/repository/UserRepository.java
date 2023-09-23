package repository;

import interfaces.UserDatabaseInterface;
import models.User;
import models.BankAccount;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to simulate user database operations.
 * Implements the UserDatabaseInterface.
 */
public class UserRepository implements UserDatabaseInterface {
    private static UserRepository clientRepository;
    private List<User> clients;

    /**
     * Private constructor ensuring singleton for the repository.
     * Initializes the client list with test data.
     */
    private UserRepository() {
        // Simulating database operation with clients
        clients = new ArrayList<>();
        clients.add(new User(1, "Client 1", "1111".hashCode(), 2));
        clients.add(new User(2, "Client 2", "2222".hashCode(), 3));
        clients.add(new User(3, "Client 3", "3333".hashCode(), 4));
        clients.add(new User(4, "Client 4", "4444".hashCode(), 5));
    }

    /**
     * Static method to get the repository instance (singleton).
     *
     * @return UserRepository instance
     */
    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (var currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                throw new RuntimeException("A client with this ID already exists");
            }
        }
        clients.add(client);

        // Creating a new bank account for the new user
        CashRepository cashRepository = CashRepository.getCashRepository();
        BankAccount newAccount = new BankAccount();
        newAccount.setCard(cardNumber); // Setting the card number
        newAccount.setBalance(1000); // Setting the initial balance, for instance, 1000
        cashRepository.getClients().add(newAccount);

        return client.getId();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (var client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new RuntimeException("Client with this ID not found");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (var client : clients) {
            var clientName = client.getUserName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("Client with this name not found");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("Client list is empty");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        User tempClient = null;
        for (User currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}
