package com.myproject.humbleproject.entities.schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HolidayCalendar")
public class HolidayCalendar {
    @Column
    private Date calendarDate;
    @Column
    private Boolean calendarHoliday;
    @Column
    private Boolean calendarWorkday;

}
