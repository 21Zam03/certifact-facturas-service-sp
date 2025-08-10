package com.certicom.certifact_facturas_service_sp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
public class PaymentVoucherFilterRequest {

    private String rucEmisor;
    private Date filtroDesde;
    private Date filtroHasta;
    private String filtroTipoComprobante;
    private String filtroRuc;
    private String filtroSerie;
    private Integer filtroNumero;
    private Integer idOficina;
    private String estadoSunat;
    private Integer numPagina;
    private Integer porPagina;
    private Integer offset;

}
