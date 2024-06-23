package com.fitmate.workoutstudy_backend_alarm.dto;

import lombok.Data;

@Data
public class ChatDto {
    private long userId;
    private String messageId;
    private int fitgroupId;
    private int fitMateId;
    private String message;
    private String messageTime;
    private String messageType;
}
