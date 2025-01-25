package pjatk.mpr.s30402bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pjatk.mpr.s30402bank.Database.ClientDatabase;
import pjatk.mpr.s30402bank.Service.ClientService;

@SpringBootApplication
public class S30402BankApplication {

    private final Bank bank;
    private final ClientService clientService;

    public S30402BankApplication(ClientService clientService) {
        this.clientService = clientService;

        this.bank = new Bank(clientService);
    }

    public static void main(String[] args) {
        SpringApplication.run(S30402BankApplication.class, args);
    }

}
