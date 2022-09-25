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
@Table(name="enterprise")
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {
    @Id
    @Column(name = "nit")
    @Getter @Setter
    private long nit;
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @Column(name = "document")
    @Getter @Setter
    private String document;
    @Column(name = "phone")
    @Getter @Setter
    private String phone;
    @Column(name = "address")
    @Getter @Setter
    private String address;

    /*

    @Column(name = "users")
    @Getter @Setter
    private long users;

    @Column(name = "transactions")
    @Getter @Setter
    private long transactions;
    @Column(name = "createdat")
    @Getter @Setter
    private LocalDate createdat;
    @Column(name = "updatedat")
    @Getter @Setter
    private LocalDate updatedat;

     */
}



