package pjatk.mpr.s30402bank.UnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Entity.Client;
import pjatk.mpr.s30402bank.Entity.Operation;
import pjatk.mpr.s30402bank.Service.ClientService;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientServiceTest {

    private ClientDatabase clientDatabase;
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientDatabase = new ClientDatabase();
        clientService = new ClientService(clientDatabase);

        clientService.registerClientWithBalance(1000);
    }

    @Test
    public void shouldRegisterClient() {
        // GIVEN
        double b = 400;
        //WHEN
        clientService.registerClientWithBalance(b);
        //THEN
        assertThat(clientDatabase.getClients().size()).isEqualTo(2);
    }

    @Test void shouldUnregisterClient() {
        // GIVEN
        int id = 1;
        // WHEN
        clientService.unregisterClientWithID(id);
        // THEN
        assertThat(clientDatabase.getClients().size()).isEqualTo(0);
    }

    @Test
    public void shouldGetClientByID() {
        // GIVEN
        Client c = clientDatabase.getClients().get(0);
        int id = 1;
        // WHEN
        Client cs = clientService.getClientWithID(id);
        // THEN
        assertThat(c).isEqualTo(cs);
    }

    @Test
    public void shouldSendMoneyAndReceiveOperation() {
        // GIVEN
        int id = 1;
        // WHEN
        Operation op = clientService.send(id, 300);
        // THEN
        assertThat(op.getStatus()).isTrue();
    }

    @Test
    public void shouldDepositMoneyAndHaveNewBalance() {
        // GIVEN
        int id = 1;
        // WHEN
        clientService.deposit(id, 1200);
        // THEN
        assertThat(clientService.getClientWithID(id).getBalance()).isEqualTo(2200);
    }

    @Test
    public void shouldntWithdrawMoneyAndReceiveOperation() {
        // GIVEN
        int id = 1;
        // WHEN
        Operation op = clientService.withdraw(id, 1200);
        // THEN
        assertThat(op.getStatus()).isFalse();
    }

}
