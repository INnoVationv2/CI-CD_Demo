package edu.ecnu.smart.agriculture.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Weather {
    private String id;
    @TableField("monitor_time")
    private LocalDateTime monitorTime;
    private String temp;
    private String humi;
    private String wind;
    private String rain;
}
