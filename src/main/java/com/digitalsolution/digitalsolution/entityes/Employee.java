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
    private long profile;

    @Column(name = "role")
    @Getter @Setter
    private String role;

    @Column(name = "enterprise")
    @Getter @Setter
    private long enterprise;

    @Column(name = "contra")
    @Getter @Setter
    private String contra;

    /*
    @Column(name = "transactions")
    @Getter @Setter
    private long transactions;

    @Column(name = "updatedat")
    @Getter @Setter
    private LocalDate updatedat;

    @Column(name = "createdat")
    @Getter @Setter
    private LocalDate createdat;

     */


}
