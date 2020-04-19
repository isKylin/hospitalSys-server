package com.example.demo.dto;

import lombok.Data;

@Data
public class BlacklistDTO {
    private Integer blacklistId;
    private String patientName;
    private String blacklistReason;
}
