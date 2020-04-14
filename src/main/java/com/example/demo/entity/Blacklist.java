package com.example.demo.entity;

import lombok.Data;

@Data
public class Blacklist {
    private int blacklist_id;
    private String patient_name;
    private String blacklist_reason;
}
