package com.example.demo.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 20:34
 */
@Data
public class AppointmentDTO {

    private Integer appointmentId;

    private Integer departmentId;

    private String departmentName;

    private Integer doctorId;

    private String doctorName;

    private Integer appointmentCount;

    private Integer appointmentRegisteredCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
}
