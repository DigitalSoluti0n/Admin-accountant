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
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "idm")
    @Getter @Setter
    private long idm;

    @Column(name = "concept")
    @Getter @Setter
    private String concept;

    @Column(name = "amount")
    @Getter @Setter
    private Double amount;

    @Column(name = "typeAmount")
    @Getter @Setter
    private String typeAmount;

    @Column(name = "usuario")
    @Getter @Setter
    private long usuario;

    @Column(name = "enterprise")
    @Getter @Setter
    private long enterprise;

    @Column(name = "createdat")
    @Getter @Setter
    private LocalDate createdat;

    @Column(name = "updatedat")
    @Getter @Setter
    private LocalDate updatedat;

}

