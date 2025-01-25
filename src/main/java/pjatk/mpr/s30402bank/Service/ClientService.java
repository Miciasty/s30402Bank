package pjatk.mpr.s30402bank.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Entity.Client;

@Service
public class ClientService {

    private final ClientDatabase clientDatabase;

    public ClientService(ClientDatabase clientDatabase) {
        this.clientDatabase = clientDatabase;
    }

    public void registerClientWithBalance(double balance) {
        int n = clientDatabase.getClients().size();

        this.clientDatabase.add(new Client(n+1, balance));
    }

    public void unregisterClientWithID(int id) {
        for (Client client : clientDatabase.getClients()) {
            if (client.getId() == id) {
                clientDatabase.remove(client);
            }
        }
    }

    /**/

    public void deposit(int id, double amount) {
        for (Client client : clientDatabase.getClients()) {
            if (client.getId() == id) {

            }
        }
    }

}
