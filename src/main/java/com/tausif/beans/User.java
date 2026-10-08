package com.tausif.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
