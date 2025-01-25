package pjatk.mpr.s30402bank.MockitoTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Entity.Client;
import pjatk.mpr.s30402bank.Entity.Operation;
import pjatk.mpr.s30402bank.Service.ClientService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientDatabase clientDatabase;

    @InjectMocks
    private ClientService clientService;

    @Test
    void shouldSendClientToDatabase() {
        // GIVEN
        double balance = 200;
        // WHEN
        clientService.registerClientWithBalance(balance);
        // THEN
        ArgumentCaptor<Client> clientCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientDatabase).add(clientCaptor.capture());

        Client client = clientCaptor.getValue();
        assertThat(client).isNotNull();
    }

    @Test
    void shouldReceiveNegativeOperation() {
        // GIVEN
        int n = 1;
        int balance = 400;
        // WHEN
        Operation op = clientService.deposit(n, balance);
        // THEN
        assertThat(op.getStatus()).isFalse();
    }

}
