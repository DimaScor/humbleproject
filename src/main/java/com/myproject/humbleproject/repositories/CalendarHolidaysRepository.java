package com.myproject.humbleproject.repositories;

import com.myproject.humbleproject.entities.schedule.HolidayCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarHolidaysRepository extends JpaRepository<HolidayCalendar,Long> {

    HolidayCalendar findByDate(LocalDate localDate);

    List<HolidayCalendar> findAllByCalendarDateBetweenAndCalendarHolidayIsFalse(LocalDate localDateStart, LocalDate localDateEnd);

    List<HolidayCalendar> findAllByCalendarDateBetweenAndCalendarWorkdayIsFalse(LocalDate localDateStart, LocalDate localDateEnd);

    List<HolidayCalendar> findAllByCalendarDateBetweenCalendarHolidayIsTrueAndCalendarWorkdayIsTrueAnd(LocalDate localDateStart, LocalDate localDateEnd);


}
