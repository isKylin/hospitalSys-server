package com.example.demo.entity;

import lombok.Data;

@Data
public class Duty {
    private int duty_id;
    private String duty_class;
    private String doctor_name;
    private String duty_time;
    private String duty_date;
    private int duty_appointment;
}
