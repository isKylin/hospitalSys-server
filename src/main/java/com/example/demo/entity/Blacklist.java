package com.example.demo.entity;

import lombok.Data;

@Data
public class Blacklist {
    private Integer blacklistId;
    private String patientName;
    private String blacklistReason;
}
