package pjatk.mpr.s30402bank.UnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pjatk.mpr.s30402bank.Entity.Client;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client(1, 1000);
    }

    @Test
    void shouldGetID() {
        // GIVEN
        int n = 1;
        // WHEN
        int c = client.getId();
        // THEN
        assertThat(n).isEqualTo(c);
    }

    @Test
    void shouldSetBalance() {
        // GIVEN
        int b = 2000;
        // WHEN
        client.setBalance(b);
        // THEN
        assertThat(client.getBalance()).isEqualTo(b);
    }

    @Test
    void shouldntWithdrawMoney() {
        // GIVEN
        double old = client.getBalance();
        int b = 2000;
        // WHEN
        client.withdraw(b);
        // THEN
        assertThat(client.getBalance()).isEqualTo(old);
    }

    @Test
    void shouldDepositMoney() {
        // GIVEN
        double old = client.getBalance();
        int b = 2000;
        // WHEN
        client.deposit(b);
        // THEN
        assertThat(client.getBalance()).isEqualTo(old + b);
    }

}
