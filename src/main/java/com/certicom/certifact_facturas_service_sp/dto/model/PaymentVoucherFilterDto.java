package com.certicom.certifact_facturas_service_sp.dto.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherFilterDto {

    private String filtroDesde;
    private String filtroHasta;
    private String filtroTipoComprobante;
    private String filtroRuc;
    private String filtroSerie;
    private Integer filtroNumero;
    private Integer pageNumber;
    private Integer perPage;
    private Integer estadoSunat;
    private Integer offset;

    private Long idUsuario;

}
