package edu.ecnu.smart.agriculture.model.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeDuration {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
