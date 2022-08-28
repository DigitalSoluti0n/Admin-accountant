package com.digitalsolution.digitalsolution.entityes;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "cedula")
    @Getter @Setter
    private long cedula;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "profile")
    @Getter @Setter
    private Profile profile;

    @Column(name = "role")
    @Getter @Setter
    private Role role;

    @Column(name = "enterprise")
    @Getter @Setter
    private long enterprise;

    @Column(name = "transactions")
    @Getter @Setter
    private long transactions;

    @Column(name = "updatedAt")
    @Getter @Setter
    private LocalDate updatedAt;

    @Column(name = "createdAt")
    @Getter @Setter
    private LocalDate createdAt;


}
