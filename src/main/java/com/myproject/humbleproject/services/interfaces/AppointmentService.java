package com.myproject.humbleproject.services.interfaces;

import com.myproject.humbleproject.entities.Appointment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public interface AppointmentService  {

    List<Appointment> getAppointmentsOfMechanicToCurrentDate(Long mechanic, Date date);

    List<Appointment> getAppointmentsByServiceType(String serviceType);

    List<Appointment> getAppointmentsByDate(Date date);

}
