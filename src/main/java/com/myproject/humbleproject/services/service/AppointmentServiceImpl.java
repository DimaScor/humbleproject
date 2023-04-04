package com.myproject.humbleproject.services.service;

import com.myproject.humbleproject.entities.Appointment;
import com.myproject.humbleproject.repositories.AppointmentRepository;
import com.myproject.humbleproject.services.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAppointmentsOfMechanicToCurrentDate(Long mechanic, Date date) {
        return appointmentRepository.findByMechanic(mechanic,date);
    }

    @Override
    public List<Appointment> getAppointmentsByServiceType(String serviceType) {
        return appointmentRepository.findByServiceType(serviceType);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(Date date) {
        return appointmentRepository.findByDate(date);
    }

}
