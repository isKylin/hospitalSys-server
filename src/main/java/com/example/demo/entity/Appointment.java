package com.example.demo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 16:18
 */
@Data
public class Appointment {
    private Integer appointmentId;

    private Integer departmentId;

    private Integer doctorId;

    private Integer appointmentCount;

    private Integer appointmentRegisteredCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
}
