package com.fitmate.workoutstudy_backend_alarm.dto;

import lombok.Data;

import java.util.List;

@Data
public class FitGroupResponse {
    private Long fitGroupId;
    private FitLeaderDetail fitLeaderDetail;
    private List<FitMateDetail> fitMateDetails;
}
