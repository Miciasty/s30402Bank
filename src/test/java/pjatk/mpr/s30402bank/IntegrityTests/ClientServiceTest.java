package pjatk.mpr.s30402bank.IntegrityTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pjatk.mpr.s30402bank.Entity.Client;
import pjatk.mpr.s30402bank.Entity.Operation;
import pjatk.mpr.s30402bank.Service.ClientService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    void hasConnectionToDatabase() {
        // GIVEN
        // WHEN
        Client c = clientService.getClientWithID(5);
        // THEN
        assertThat(c).isNull();
    }

    @Test
    void sendsMoneyToSomeoneElse() {
        // GIVEN
        clientService.registerClientWithBalance(1200);
        int n = 1;
        // WHEN
        Operation op = clientService.send(n, 200);
        // THEN
        assertThat(op.getStatus()).isTrue();
        assertThat(clientService.getClientWithID(n).getBalance()).isEqualTo(1000);

        clientService.unregisterClientWithID(n);

        assertThat(clientService.getClientWithID(n)).isNull();
    }

    @Test
    void cannotDepositMoney() {
        // GIVEN
        clientService.registerClientWithBalance(1200);
        int n = 1;
        // WHEN
        Operation op = clientService.send(n, 2000);
        // THEN
        assertThat(op.getStatus()).isFalse();
        assertThat(clientService.getClientWithID(n).getBalance()).isEqualTo(1200);

        clientService.unregisterClientWithID(n);

        assertThat(clientService.getClientWithID(n)).isNull();
    }
}
