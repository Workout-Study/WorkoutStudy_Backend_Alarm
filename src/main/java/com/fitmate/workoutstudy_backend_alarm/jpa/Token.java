package com.fitmate.workoutstudy_backend_alarm.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Token {

    @Id
    private Integer id;

    private String username;
    private String value;
}
