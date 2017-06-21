package models;

import static models.Amount.toAmount;

/**
 * This class represent the Account Model containing an Operation and an Amount
 */
public class Account {

    private Operation operation;
    private Amount balance = toAmount(0);

    /**
     * Constructor using operation param
     * @param operation
     */
    public Account(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Amount getBalance() {
        return balance;
    }

    public void setBalance(Amount balance) {
        this.balance = balance;
    }
}
