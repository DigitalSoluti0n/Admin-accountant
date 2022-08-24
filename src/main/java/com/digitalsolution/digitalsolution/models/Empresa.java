package com.digitalsolution.digitalsolution.models;

import lombok.Getter;
import lombok.Setter;

public class Empresa {

    @Getter @Setter
    private String nombreEmpresa;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private int telefono;
    @Getter @Setter
    private int nit;

}
