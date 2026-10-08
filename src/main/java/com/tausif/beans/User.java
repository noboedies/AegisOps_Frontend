package com.tausif.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String email;
    private String username;
    private String name;
    private String phone;
    private String organization;
    private String status;
    private String password;
//    @Column(nullable = true, columnDefinition = "longblob")
//    private byte[] profile;

}
