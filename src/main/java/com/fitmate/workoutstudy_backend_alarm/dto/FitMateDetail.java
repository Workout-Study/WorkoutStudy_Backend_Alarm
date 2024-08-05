package com.fitmate.workoutstudy_backend_alarm.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class FitMateDetail {
    private Long fitMateId;
    private Long fitMateUserId;
    private String fitMateUserNickname;
    private String createdAt;
}
