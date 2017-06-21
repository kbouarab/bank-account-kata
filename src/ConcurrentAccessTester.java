

import models.Account;
import models.Operation;
import services.AccountService;

import java.util.Date;

import static models.Amount.toAmount;

public class ConcurrentAccessTester implements Runnable {

    Account account = new Account(new Operation());
    AccountService accountService = new AccountService(account);

    public static void main(String[] args) {


        ConcurrentAccessTester concurrentAccessTester = new ConcurrentAccessTester();

        Thread t1 = new Thread(concurrentAccessTester, "person 1");
        Thread t2 = new Thread(concurrentAccessTester, "person 2");

        t1.start();
        t2.start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 1; i++) {

            /**
             * US 1:
             * In order to save money
             * As a bank client
             * I want to make a deposit in my account
             */
            accountService.newDeposit(toAmount(1000), new Date("20/06/2017"));

            /**
             US 2:
             * In order to retrieve some or all of my savings
             * As a bank client
             * I want to make a withdrawal from my account
             */
            accountService.newWithdrawal(toAmount(500), new Date("21/06/2017"));

        }


        /**
         * US 3:
         * In order to check my operations
         * As a bank client
         * I want to see the history (operation, date, amount, balance)  of my operations
         */
        accountService.printOperationsHistory(System.out);

        System.out.println("=========================================");
    }
}
