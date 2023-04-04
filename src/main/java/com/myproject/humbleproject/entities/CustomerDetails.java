package com.myproject.humbleproject.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotBlank
    @Column(name = "address")
    private String address;

    @Column(name = "vehicle_list")
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicle> vehicleList;

    @NotBlank
    @Column(name = "user")
    @OneToOne(mappedBy = "customer_details")
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "orders")
    @OneToMany(mappedBy = "customer_details", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

}
