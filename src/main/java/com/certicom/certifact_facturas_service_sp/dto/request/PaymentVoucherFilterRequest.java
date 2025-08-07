package com.certicom.certifact_facturas_service_sp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PaymentVoucherFilterRequest {

    private LocalDate filtroDesde;
    private LocalDate filtroHasta;
    private String filtroTipoComprobante;
    private String filtroRuc;
    private String filtroSerie;
    private Integer filtroNumero;
    private Integer pageNumber;
    private Integer perPage;
    private String estadoSunat;
    private Integer offset;

}
