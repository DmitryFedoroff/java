package interfaces;

/**
 * Interface for interacting with the bank transactions database.
 * Provides methods for conducting transactions between bank cards.
 */
public interface PaymentTransactionInterface {

    /**
     * Conducts a transaction between two bank cards.
     *
     * @param payment  The payment amount in minimal monetary units (for example, pennies or cents).
     * @param cardFrom The sender's bank card number.
     * @param cardTo   The recipient's bank card number.
     * @return true if the transaction was successful, and false otherwise.
     */
    boolean transaction(int payment, long cardFrom, long cardTo);
}
