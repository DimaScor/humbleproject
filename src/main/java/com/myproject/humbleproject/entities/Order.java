package com.myproject.humbleproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_details_id")
    private CustomerDetails customerDetails;

}