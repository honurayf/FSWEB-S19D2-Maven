package com.workintech.s18d4.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer", schema = "fsweb")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

}
