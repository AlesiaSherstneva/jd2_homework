package by.academy.it;

import java.math.BigDecimal;

public class Expense {
    private String paydate;
    private int receiver;
    private BigDecimal value;

    public Expense() {
    }

    public Expense(String paydate, int receiver, BigDecimal value) {
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
