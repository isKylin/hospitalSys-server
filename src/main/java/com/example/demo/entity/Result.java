package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    private int code;
    private String message;
    private Object data;

}