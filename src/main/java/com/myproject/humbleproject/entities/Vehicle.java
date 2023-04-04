package com.myproject.humbleproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    @NotBlank
    @Column(name = "model")
    private String model;
    @NotBlank
    @Column(name = "year")
    private Date year;
    @Column(name = "color")
    private String color;
    @NotBlank
    @Column(name = "license")
    private String license;
    @Column(name = "lastServiceDate")
    private String lastServiceDate;
    @Column(name = "engineSize")
    private String engineSize;
    @Column(name = "tireSize")
    private String tireSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_details_id")
    private CustomerDetails customerDetails;

}
