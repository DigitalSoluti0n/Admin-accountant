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
    @Column(name = "id")
    @Getter @Setter
    private long id;

    @Column(name = "concept")
    @Getter @Setter
    private String concept;

    @Column(name = "amount")
    @Getter @Setter
    private Double amount;

    @Column(name = "typeAmount")
    @Getter @Setter
    private String typeAmount;

    @Column(name = "user")
    @Getter @Setter
    private long user;

    @Column(name = "enterprise")
    @Getter @Setter
    private long enterprise;

    @Column(name = "createdAt")
    @Getter @Setter
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    @Getter @Setter
    private LocalDate updatedAt;

}

