package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComprobanteArchivo {

    private Long id;
    private String tipoArchivo;
    private String orden;
    private String estadoArchivo;
    private Long idPaymentVoucher;
    private Long subidaRegistroArchivoId;

}
