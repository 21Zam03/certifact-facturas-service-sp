package com.certicom.certifact_facturas_service_sp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnticipoEntity {

    private Integer idAnticipoPayment;
    private String serieAnticipo;
    private Integer numeroAnticipo;
    private String tipoDocAnticipo;
    private BigDecimal montoAnticipo;
    private Long idpaymentVoucher;

}
