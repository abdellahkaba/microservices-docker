package net.kaba.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.kaba.accountservice.enums.AccountType;
import net.kaba.accountservice.models.Customer;

import java.time.LocalDate;

@Entity @Getter @Setter @Builder @ToString @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    @Id
    private String accountId ;
    private double balance ;
    private String currency ;
    private LocalDate createAt ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @Transient
    private Customer customer ;
    private Long customerId ;
}
