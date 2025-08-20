package com.certicom.certifact_facturas_service_sp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchOfficeEntity {

    private Integer id;
    private String nombreCorto;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
    private boolean estado;
    private Date createdOn;
    private String createdBy;
    private String updatedBy;
    private Date updatedOn;


}
