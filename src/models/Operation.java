package models;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * This Class Record every Operation
 */
public class Operation {

    private static final int START_LIST = 0;

    public static final String OPERATION_HEADER = "date       | credit   | debit    | Montant";

    private List<OperationLine> operationLines = new LinkedList<>();

    public void addNewOperation(Transaction transaction, Amount currentBalance) {
        operationLines.add(START_LIST, new OperationLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(OPERATION_HEADER);
        printOperationLines(printer);
    }

    private void printOperationLines(PrintStream printer) {
        for (OperationLine operationLine : operationLines) {
            operationLine.printTo(printer);
        }
    }

}
