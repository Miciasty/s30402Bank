package pjatk.mpr.s30402bank.Entity;

public class Client {

    private final int id;

    private double balance;

    public Client(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance < amount) return;
        balance -= amount;
    }
}
