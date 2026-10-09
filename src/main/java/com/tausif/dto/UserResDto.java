package com.tausif.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserResDto {

    private String email;
    private String username;
    private String name;
    private String phone;
    private String organization;
    private String status;
//    private byte[] profile;

}
