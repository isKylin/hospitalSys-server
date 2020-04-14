package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_role;
}
