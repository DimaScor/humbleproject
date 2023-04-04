package com.myproject.humbleproject.services.interfaces;

import org.springframework.stereotype.Service;
import com.myproject.humbleproject.entities.schedule.HolidayCalendar;

import java.time.LocalDate;
import java.util.List;


@Service
public interface HolidayService {

    List<HolidayCalendar> getCurrentHolidayByDate(LocalDate localDate);

    List<HolidayCalendar> getPeriodWithoutHolidays(LocalDate localDateStart, LocalDate localDateEnd);

    List<HolidayCalendar> getPeriodWithHoliday(LocalDate localDateStart, LocalDate localDateEnd);

    List<HolidayCalendar> getPeriodWithWorkOnHoliday(LocalDate localDateStart, LocalDate localDateEnd);


}
