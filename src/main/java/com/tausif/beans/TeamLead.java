package com.tausif.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLead {

    private String name;
    private String email;
    private String pmEmail;
    private String userEmail;
    private String username;
    private String phone;
    private String status;
    private String empId;
    private String password;
    private byte[] profile;
    private byte[] idCard;

}
