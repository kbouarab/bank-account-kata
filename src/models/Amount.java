package models;

import java.text.DecimalFormat;

/**
 * This class represent the Account Amount Model containing value and amount operations
 */
public class Amount {

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private int value;

    public int getValue() {
        return value;
    }

    public Amount(int value) {
        this.value = value;
    }

    public static Amount toAmount(int value) {
        return new Amount(value);
    }

    public Amount addition(Amount otherAmount) {
        return toAmount(this.value + otherAmount.value);
    }

    public boolean isGreaterThan(Amount otherAmount) {
        return this.value > otherAmount.value;
    }

    public Amount absoluteValue() {
        return toAmount(Math.abs(value));
    }

    public String moneyRepresentation() {
        return decimalFormat.format(value);
    }

    public Amount toNegative() {
        return toAmount(-value);
    }

    @Override
    public boolean equals(Object obj) {
        Amount other = (Amount) obj;
        if (value != other.value)
            return false;
        return true;
    }

}
