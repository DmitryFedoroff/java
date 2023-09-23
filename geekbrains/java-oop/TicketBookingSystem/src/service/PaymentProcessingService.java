package service;

import interfaces.CarrierDatabaseInterface;
import interfaces.PaymentTransactionInterface;
import models.Carrier;
import models.Ticket;
import models.User;
import repository.CarrierRepository;
import repository.CashRepository;

/**
 * Provider class for interaction with the bank and the carrier database.
 * Responsible for payment authorization and transaction execution.
 */
public class PaymentProcessingService {

    private long cardNumber;
    private boolean isAuthorized = false;
    private CarrierDatabaseInterface carrierRepository;
    private PaymentTransactionInterface cashRepository;

    /**
     * Class constructor initializing repositories for working with carriers and the cash register.
     * Implements the Singleton pattern for repositories.
     */
    public PaymentProcessingService() {
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Method for buying a ticket. Checks if authorization has been carried out, and if so,
     * carries out the ticket purchase transaction.
     *
     * @param ticket the ticket to be purchased
     * @return true if the purchase was successful, otherwise false
     * @throws RuntimeException in case of an error during ticket purchase
     */
    public boolean buy(Ticket ticket) {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
        }
        return false;
    }

    /**
     * Method for user authorization. In the current implementation, it simply saves the user's card number
     * and sets the authorization flag to true.
     *
     * @param client the user attempting to authorize
     */
    public void authorization(User client) {
        cardNumber = client.getCardNumber();
        isAuthorized = true;
    }
}
