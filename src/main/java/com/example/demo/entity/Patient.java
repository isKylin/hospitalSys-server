package com.example.demo.entity;

import lombok.Data;

@Data
public class Patient {
    private int patient_id;
    private String patient_name;
    private String patient_phone;
    private String patient_idcard;
}
