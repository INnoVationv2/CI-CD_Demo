package edu.ecnu.smart.agriculture.model;

import lombok.Data;

@Data
public class FarmInfo {
    private Integer id;
    private String location;
    private String crop;
    private String status;
    private String comment;
}
