package edu.ecnu.smart.agriculture.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Equipment {
    private Integer id;
    private String name;
    private String status;
    @TableField("farm_id")
    private String farmId;
}
