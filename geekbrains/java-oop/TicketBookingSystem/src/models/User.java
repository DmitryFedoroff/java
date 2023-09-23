package models;

import java.util.Objects;

/**
 * Class representing a user model.
 * Stores information about the user's ID, their name, hashed password, and bank card number.
 */
public class User {

    private int id; // Unique user identifier
    private String userName; // User name
    private int hashPassword; // User password hash
    private long cardNumber; // User's bank card number

    /**
     * Constructor for creating a user object with specified parameters.
     *
     * @param id           unique user identifier
     * @param userName     user name
     * @param hashPassword user password hash
     * @param cardNumber   user's bank card number
     */
    public User(int id, String userName, int hashPassword, long cardNumber) {
        this.id = id;
        this.userName = userName;
        this.hashPassword = hashPassword;
        this.cardNumber = cardNumber;
    }

    // Getters for class fields with corresponding comments

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getHashPassword() {
        return hashPassword;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    // Overridden toString method with card number formatting

    @Override
    public String toString() {
        return "Client { " +
                "id= " + id +
                ", userName= " + userName +
                ", cardNumber= " + (String.format("%016d", cardNumber)) +
                " }";
    }

    // Overridden equals and hashCode methods for comparing objects and obtaining the object's hash code

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.equals(user);
    }

    public boolean equals(User user) {
        return id == user.id && hashPassword == user.hashPassword && cardNumber == user.cardNumber && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, hashPassword, cardNumber);
    }
}
