package net.kaba.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.kaba.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    //cette interface permet de chercher un customer client
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    //une methode qui return liste de customer
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers() ;

    default Customer getDefaultCustomer (Long id, Exception exception) {
        Customer customer = new Customer() ;
        customer.setId(id);
        customer.setName("NameDefault");
        customer.setEmail("EmailDefault");
        return customer ;

    }

    default List<Customer> getAllCustomer (Exception exception) {
        return  List.of();
    }
}
