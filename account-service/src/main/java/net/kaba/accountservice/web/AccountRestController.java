package net.kaba.accountservice.web;


import lombok.AllArgsConstructor;
import net.kaba.accountservice.clients.CustomerRestClient;
import net.kaba.accountservice.entities.BankAccount;
import net.kaba.accountservice.models.Customer;
import net.kaba.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {

    private BankAccountRepository bankAccountRepository ;
    private CustomerRestClient customerRestClient ;
    @GetMapping("/accounts")
    public List<BankAccount> accountList () {
        List<BankAccount> accountList = bankAccountRepository.findAll() ;
        accountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList ;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){

        BankAccount bankAccount = bankAccountRepository.findById(id).get() ;
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId()) ;
        bankAccount.setCustomer(customer);
        return bankAccount ;
    }
}
