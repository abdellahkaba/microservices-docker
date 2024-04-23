package net.kaba.accountservice;

import net.kaba.accountservice.clients.CustomerRestClient;
import net.kaba.accountservice.entities.BankAccount;
import net.kaba.accountservice.enums.AccountType;
import net.kaba.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){

        return args -> {
            customerRestClient.allCustomers().forEach(customer -> {
                BankAccount account1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(2000)
                        .currency("F CFA")
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                BankAccount account2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(3000)
                        .currency("F CFA")
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                BankAccount account3 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(4000)
                        .currency("F CFA")
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                BankAccount account4 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(5000)
                        .currency("F CFA")
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                bankAccountRepository.save(account1);
                bankAccountRepository.save(account2);
                bankAccountRepository.save(account3);
                bankAccountRepository.save(account4);
            });



        };
    }
}
