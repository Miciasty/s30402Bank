package pjatk.mpr.s30402bank.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Entity.Client;
import pjatk.mpr.s30402bank.Entity.Operation;

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

    public String getClientData(int id) {
        for (Client client : clientDatabase.getClients()) {
            if (client.getId() == id) {
                return client.toString();
            }
        }
        return null;
    }

    /**/

    public Operation send(int id, double amount) {
        return this.withdraw(id, amount);
    }

    public Operation deposit(int id, double amount) {
        for (Client client : clientDatabase.getClients()) {
            if (client.getId() == id) {
                client.deposit(amount);

                return new Operation(amount, true);

            }
        }
        System.out.println("Client doesn't have account in this bank.");
        return new Operation(amount, false);
    }

    public Operation withdraw(int id, double amount) {
        for (Client client : clientDatabase.getClients()) {
            if (client.getId() == id) {

                if (client.getBalance() < amount) {
                    System.out.println("Client doesn't have enough balance");
                    return new Operation(amount, false);
                }

                client.withdraw(amount);

                return new Operation(amount, true);
            }
        }
        System.out.println("Client doesn't have account in this bank.");
        return new Operation(amount, false);
    }

}
