package com.digitalsolution.digitalsolution.entityes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Getter@Setter
    private long id;
    @Getter@Setter
    private String concept;
    @Getter@Setter
    private Double amount;
    @Getter@Setter
    private Amount typeAmount;
    @Getter@Setter
    private Employee user;
    @Getter@Setter
    private Enterprise enterprise;
    @Getter@Setter
    private Date createdAt;
    @Getter@Setter
    private Date updatedAt;

}

