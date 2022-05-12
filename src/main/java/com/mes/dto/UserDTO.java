package com.mes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private int id;
    private String userId;
    private String name;
    private String password;

}
