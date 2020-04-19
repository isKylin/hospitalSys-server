package com.example.demo.dto;

import lombok.Data;

@Data
public class DutyDTO {
    private Integer dutyId;
    private String dutyClass;
    private String doctorName;
    private String dutyTime;
    private String dutyDate;
    private Integer dutyAppointment;
}
