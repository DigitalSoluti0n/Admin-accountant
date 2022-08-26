package com.digitalsolution.digitalsolution.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Getter@Setter
    private String id;
    @Getter@Setter
    private String image;
    @Getter@Setter
    private String phone;
    @Getter@Setter
    private Employee user;
    @Getter@Setter
    private Date createdAt;
    @Getter@Setter
    private Date updatedAt;


}
