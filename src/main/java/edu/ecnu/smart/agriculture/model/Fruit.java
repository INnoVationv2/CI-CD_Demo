package edu.ecnu.smart.agriculture.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Fruit {
    private Integer id;
    @TableField("farm_id")
    private Integer farmId;
    @TableField("sale_date")
    private LocalDate saleDate;
    @TableField("start_date")
    private LocalDate startDate;
    @TableField("end_date")
    private LocalDate endDate;
}
