package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherFileModel {

    private Long id;
    private String tipoArchivo;
    private String estadoArchivo;
    private Long idPaymentVoucher;
    private Long idRegisterFileSend;
    private Integer orden;

}
