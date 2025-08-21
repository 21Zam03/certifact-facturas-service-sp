package com.certicom.certifact_facturas_service_sp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TmpVoucherSendBillEntity {

    private Long idTmpSendBill;
    private Long idPaymentVoucher;
    private String estado;
    private String nombreDocumento;
    private String uuidSaved;
    private String tipoComprobante;

}
