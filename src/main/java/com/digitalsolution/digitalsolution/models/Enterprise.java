package com.digitalsolution.digitalsolution.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String document;
    @Getter @Setter
    private String phone;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private Employee[] users;
    @Getter @Setter
    private Transaction[] transactions;
    @Getter @Setter
    private Date createdAt;
    @Getter @Setter
    private Date updatedAt;
}



