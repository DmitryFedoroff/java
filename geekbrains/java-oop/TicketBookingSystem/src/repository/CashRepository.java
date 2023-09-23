package repository;

import interfaces.PaymentTransactionInterface;
import models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class simulating the operation with the bank database.
 * Implements the PaymentTransactionInterface interface.
 * Uses the Singleton pattern to create a single instance of the class.
 */
public class CashRepository implements PaymentTransactionInterface {
    private static CashRepository cashRepository; // The single instance of the class
    private List<BankAccount> clients; // List of client bank accounts

    /**
     * Method to get the list of client bank accounts.
     *
     * @return list of client bank accounts
     */
    public List<BankAccount> getClients() {
        return clients;
    }

    /**
     * Private constructor initializing the list of client bank accounts.
     * Adds five bank accounts with an initial balance to the list.
     */
    private CashRepository() {
        clients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            clients.add(new BankAccount());
        }
    }

    /**
     * Static method returning the single instance of the class.
     * If the instance was not created earlier, it creates a new one.
     *
     * @return the single instance of the CashRepository class
     */
    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    /**
     * Method to conduct a transaction between two bank accounts.
     * Checks the existence of accounts and sufficient funds to conduct the transaction.
     * In case of successful validation, conducts the transaction, changing the account balances.
     *
     * @param payment     payment amount
     * @param cardFrom    sender's card number
     * @param carrierCard recipient's card number
     * @return true, if the transaction was successful, otherwise false
     * @throws RuntimeException if validation failed, with a message indicating the reason
     */
    @Override
    public boolean transaction(int payment, long cardFrom, long carrierCard) throws RuntimeException {
        BankAccount from = null;
        BankAccount to = null;

        // Searching for the sender's and recipient's bank accounts
        for (var client : clients) {
            if (client.getCard() == cardFrom) {
                from = client;
            }
            if (client.getCard() == carrierCard) {
                to = client;
            }
        }

        // Checking the existence of accounts
        if (from == null) {
            throw new RuntimeException("Account for withdrawal not found.");
        }
        if (to == null) {
            throw new RuntimeException("Account for deposit not found.");
        }

        // Checking the sender's account balance
        if (from.getBalance() - payment < 0) {
            throw new RuntimeException("Insufficient funds in the account.");
        }

        // Checking the recipient's account balance
        if (to.getBalance() > Integer.MAX_VALUE - payment) {
            throw new RuntimeException("Too large amount to be credited to the account.");
        }

        // Conducting the transaction with updating account balances
        try {
        } finally {
            clients.remove(from);
            clients.remove(to);
            from.setBalance(from.getBalance() - payment);
            to.setBalance(to.getBalance() + payment);
            clients.add(from);
            clients.add(to);
        }
        return true;
    }
}
