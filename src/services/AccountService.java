package services;


import models.Account;
import models.Amount;
import models.Transaction;

import java.io.PrintStream;
import java.util.Date;

/**
 * This class manipulate the Account operations
 */
public class AccountService {

    private Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    /**
     * deposit amount into account
     * @param value
     * @param date
     */
    public synchronized void newDeposit(Amount value, Date date) {
        if (value.getValue() > 0) {
            System.out.println(Thread.currentThread().getName()+" "+ " is try to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.newTransaction(value, date);
        }else{
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for deposit");
        }
    }

    /**
     * withdraw amount from account
     * @param value
     * @param date
     */
    public synchronized void newWithdrawal(Amount value, Date date) {
        if (account.getBalance().getValue() >= value.getValue()) {
            System.out.println(Thread.currentThread().getName()+" "+ "is try to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.newTransaction(value.toNegative(), date);
        }else{
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for withdraw ");
        }
    }

    /**
     * Adding a new transaction
     * @param value
     * @param date
     */
    private void newTransaction(Amount value, Date date) {
        Transaction transaction = new Transaction(value, date);
        Amount balanceAfterTransaction = transaction.balanceAfterTransaction(account.getBalance());
        account.setBalance(balanceAfterTransaction);
        account.getOperation().addNewOperation(transaction, balanceAfterTransaction);
    }

    public void printOperationsHistory(PrintStream printer) {
        account.getOperation().printTo(printer);
    }
}
