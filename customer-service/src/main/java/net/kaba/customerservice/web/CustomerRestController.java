package net.kaba.customerservice.web;

import lombok.AllArgsConstructor;
import net.kaba.customerservice.entities.Customer;
import net.kaba.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository ;

    @GetMapping("/customers")
    public List<Customer> listCustomer (){
        return customerRepository.findAll() ;
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).get() ;
    }

}
