package edu.ecnu.smart.agriculture.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Specialist {
    private Integer id;
    private String name;
    private String specialize;
    @TableField("work_time")
    private String workTime;
    private String phone;
}
