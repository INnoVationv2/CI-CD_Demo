package edu.ecnu.smart.agriculture.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class FarmLandStatus {
    private Integer id;
    @TableField("farm_id")
    private Integer farmId;
    @TableField("monitor_time")
    private String monitorTime;
    private String temp;
    private String ph;
    private String moi;
    private String salt;
}
