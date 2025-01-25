package pjatk.mpr.s30402bank;

import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Service.ClientService;

public class Bank {

    private final ClientService clientService;

    public Bank(ClientService clientService) {
        this.clientService = clientService;
    }


}
