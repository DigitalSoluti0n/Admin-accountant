package com.digitalsolution.digitalsolution.entityes;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Getter@Setter
    private long cedula;
    @Getter@Setter
    private String name;
    @Getter@Setter
    private String email;
    @Getter@Setter
    private Profile profile;
    @Getter@Setter
    private Role role;
    @Getter@Setter
    private Enterprise enterprise;
    @Getter@Setter
    private Transaction[] transactions;
    @Getter@Setter
    private Date updatedAt;
    @Getter@Setter
    private Date createdAt;


}
