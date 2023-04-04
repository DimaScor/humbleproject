package com.myproject.humbleproject.repositories;


import com.myproject.humbleproject.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = :appointmentDate")
    List<Appointment> findByDate(@Param("appointmentDate")Date appointmentDate);

    @Query("SELECT a FROM Appointment a WHERE a.mechanic.id = :mechanic and a.appointmentDate = :appointmentDate")
    List<Appointment> findByMechanic(Long mechanic, Date appointmentDate);

    @Query("SELECT a FROM Appointment a WHERE a.serviceType = :serviceType")
    List<Appointment> findByServiceType(String serviceType);
}
