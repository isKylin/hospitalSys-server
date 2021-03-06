package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 16:18
 */
@Data
public class Registered {

    private Integer registeredId;

    private Integer patientId;

    private String registeredStatus;

    private String registeredPay;

    private String diagnosis;

    private Integer appointmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registeredDate;
}
