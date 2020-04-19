package com.example.demo.entity;

import lombok.Data;

@Data
public class Duty {
    private Integer dutyId;
    private String dutyClass;
    private String doctorName;
    private String dutyTime;
    private String dutyDate;
    private Integer dutyAppointment;
}
