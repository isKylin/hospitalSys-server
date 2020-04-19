package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String userPassword;
    private String userRole;
}
