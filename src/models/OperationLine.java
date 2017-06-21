package models;

import java.io.PrintStream;

public class OperationLine {

    private Transaction transaction;
    private Amount currentBalance;

    public OperationLine(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    public void printTo(PrintStream printer) {
        this.transaction.printTo(printer, currentBalance);
    }

}
