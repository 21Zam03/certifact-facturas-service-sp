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
public class ComprobanteEntity {

    private String serie;
    private Integer numero;
    private String fechaEmision;
    private Date fechaEmisionDate;
    private String horaEmision;
    private String tipoComprobante;
    private String codigoMoneda;
    private String fechaVencimiento;
    private String tipoOperacion;
    private String rucEmisor;
    private String codigoLocalAnexo;
    private String tipoDocIdentReceptor;
    private String numDocIdentReceptor;
    private String denominacionReceptor;
    private String direccionReceptor;
    private String emailReceptor;

}
