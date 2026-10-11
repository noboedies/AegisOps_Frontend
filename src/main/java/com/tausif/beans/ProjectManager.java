package com.tausif.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectManager {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String empId;
    private String status;
//    private byte[] profile;
//    private byte[] idCard;

}
