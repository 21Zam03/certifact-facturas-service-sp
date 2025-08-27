package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuiaRelacionada {

    private Long idguiaremision;
    private String codigoTipoGuia;
    private String serieNumeroGuia;
    private Long idPaymentVoucher;

}
