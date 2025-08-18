package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampoAdicionalComprobante {

    private Long id;
    private String valorCampo;
    private Long idComprobante;
    private Long idCampoAdicional;

}
