package com.tausif.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegDto {

    private String email;
    private String username;
    private String name;
    private String phone;
    private String organization;
    private String status;
    private String password;
//    private byte[] profile;

}
