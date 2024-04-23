package net.kaba.customerservice;

import net.kaba.customerservice.config.GlobalConfig;
import net.kaba.customerservice.entities.Customer;
import net.kaba.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner (CustomerRepository customerRepository) {
        return args -> {
            Customer customer1 = Customer.builder()
                    .name("Abdellah Kaba")
                    .email("abdellah@gmail.com")
                    .build();
            customerRepository.save(customer1);
            Customer customer2 = Customer.builder()
                    .name("Issa Kallo")
                    .email("issa@gmail.com")
                    .build();
            customerRepository.save(customer2);
            Customer customer3 = Customer.builder()
                    .name("Fatma Bah")
                    .email("fatma@gmail.com")
                    .build();
            customerRepository.save(customer3);
            Customer customer4 = Customer.builder()
                    .name("Ousmane Sonko")
                    .email("ousmane@gmail.com")
                    .build();
            customerRepository.save(customer4);
        };
    }
}
