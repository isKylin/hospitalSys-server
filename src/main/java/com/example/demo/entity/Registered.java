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

    private int registeredId;

    private int patientId;

    private String registeredStatus;

    private String registeredPay;

    private String diagnosis;

    private int appointmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date registeredDate;
}
