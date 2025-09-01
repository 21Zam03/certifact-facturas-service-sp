package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherFilterDto {

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
