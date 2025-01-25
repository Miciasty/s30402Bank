package pjatk.mpr.s30402bank.UnitTests;

import org.junit.jupiter.api.BeforeEach;
import pjatk.mpr.s30402bank.Database.ClientDatabase;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientDatabaseTest {

    private ClientDatabase clientDatabase;

    @BeforeEach
    public void setUp() {
        clientDatabase = new ClientDatabase();
    }

}
