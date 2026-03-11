package com.example.enviroassessment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {

    private long id;

    private String name;

    private String emailAddress;

    private String password;
}
