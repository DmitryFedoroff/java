package models;

/**
 * Class representing a bank account model.
 * Stores information about the card number and the account balance.
 */
public class BankAccount {

    private long card; // Card number
    private static long oldCard; // Previous card number
    private int balance; // Account balance

    /**
     * Default constructor, initializing the initial balance and setting the card number.
     */
    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    /**
     * Method to set the account balance.
     *
     * @param balance new balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Method to set the card number.
     *
     * @param card new card number
     */
    public void setCard(long card) {
        this.card = card;
    }

    /**
     * Method to get the card number.
     *
     * @return card number
     */
    public long getCard() {
        return card;
    }

    /**
     * Method to get the account balance.
     *
     * @return account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Overridden toString method to represent the object as a string.
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}
