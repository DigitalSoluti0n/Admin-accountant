package com.digitalsolution.digitalsolution.entityes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @Column(name = "cedula")
    @Getter@Setter
    private long cedula;

    @Column(name = "image")
    @Getter@Setter
    private String image;

    @Column(name = "phone")
    @Getter@Setter
    private String phone;

    @Column(name = "usuario")
    @Getter@Setter
    private long usuario;

    @Column(name = "createdat")
    @Getter@Setter
    private LocalDate createdat;

    @Column(name = "updatedat")
    @Getter@Setter
    private LocalDate updatedat;


}
