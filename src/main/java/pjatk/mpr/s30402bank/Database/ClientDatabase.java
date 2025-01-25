package pjatk.mpr.s30402bank.Database;

import org.springframework.stereotype.Component;
import pjatk.mpr.s30402bank.Entity.Client;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDatabase {

    private final List<Client> clients;

    public ClientDatabase() {
        clients = new ArrayList<>();
    }

    public void add(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
            System.out.println("Client added: " + client);
        }
    }

    public void remove(Client client) {
        if (clients.contains(client)) {
            clients.remove(client);
            System.out.println("Client removed: " + client);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    /* --- --- */

    private boolean isAlreadyInDatabase(Client client) {
        return clients.contains(client);
    }

}
