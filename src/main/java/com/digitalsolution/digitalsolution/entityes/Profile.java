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
    @Column(name = "id")
    @Getter@Setter
    private String id;

    @Column(name = "image")
    @Getter@Setter
    private String image;

    @Column(name = "phone")
    @Getter@Setter
    private String phone;

    @Column(name = "user")
    @Getter@Setter
    private long user;

    @Column(name = "createdAt")
    @Getter@Setter
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    @Getter@Setter
    private LocalDate updatedAt;


}
