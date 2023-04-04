package com.myproject.humbleproject.repositories;


import com.myproject.humbleproject.entities.User;
import com.myproject.humbleproject.entities.schedule.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkersScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findByDate(LocalDate date);
    List<WorkSchedule> findByUser(User user);
}

