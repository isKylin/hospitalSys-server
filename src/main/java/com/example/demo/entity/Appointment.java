package com.example.demo.entity;

import lombok.Data;

@Data
public class Appointment {
    private int appointment_id;
    private String patient_name;
    private String department_name;
    private String doctor_name;
    private String appointment_reason;
    private String appointment_status;
    private String appointment_pay;
}
