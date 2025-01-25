package pjatk.mpr.s30402bank.Entity;

public class Operation {

    private final int client_id;
    private final double amount;

    private boolean status;

    public Operation(int client_id, double amount) {
        this.client_id = client_id;
        this.amount = amount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public int getClient_id() {
        return client_id;
    }

    public double getAmount() {
        return amount;
    }

}
