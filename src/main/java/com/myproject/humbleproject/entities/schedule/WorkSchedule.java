package com.myproject.humbleproject.entities.schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "WorkSchedule")
public class WorkSchedule {
    @Column
    private Date calendarDate;
    @Column
    private Boolean calendarHoliday;
    @Column
    private Boolean calendarWorkday;
    @Column
    private LocalTime workStart;
    @Column
    private LocalTime workEnd;
    @Column
    private LocalTime lunchStart;
    @Column
    private LocalTime lunchEnd;
    @Column
    private LocalTime extraWorkStart;
    @Column
    private LocalTime extraWorkEnd;
}