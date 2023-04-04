package com.myproject.humbleproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "appointment_date")
    private Date appointmentDate;

    @NotBlank
    @Column(name = "appointment_time")
    private String appointmentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_details_id")
    private CustomerDetails customerDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id")
    private User mechanic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "service_description")
    private String serviceDescription;

}
