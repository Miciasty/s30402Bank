package pjatk.mpr.s30402bank.Entity;

public class Operation {

    private final double amount;

    private boolean status;

    public Operation(double amount, boolean status) {
        this.amount = amount;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

}
