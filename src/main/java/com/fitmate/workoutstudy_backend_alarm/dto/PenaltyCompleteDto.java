package com.fitmate.workoutstudy_backend_alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyCompleteDto {
    private long userId;
    private String message;
}