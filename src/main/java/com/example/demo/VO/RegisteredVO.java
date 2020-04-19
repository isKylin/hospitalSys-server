package com.example.demo.VO;

import com.example.demo.entity.Registered;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/19 1:01
 */
@Data
public class RegisteredVO extends Registered {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
    private Integer appointmentCount;
    private Integer appointmentRegisteredCount;
    private Integer appointmentId;

}
