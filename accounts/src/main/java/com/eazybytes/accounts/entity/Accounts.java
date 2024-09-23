package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Accounts extends  BaseEntity {

    @Id
   private Long accountNumber;
    private Long customerId;

    private String name;

    private String email;


    private String mobileNumber;
}
