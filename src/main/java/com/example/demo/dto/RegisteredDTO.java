package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 21:26
 */
@Data
public class RegisteredDTO extends AppointmentDTO {

    private String registeredStatus;

    private String registeredPay;

    private String diagnosis;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registeredDate;
}
