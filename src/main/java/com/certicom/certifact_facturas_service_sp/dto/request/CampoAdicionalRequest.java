package com.certicom.certifact_facturas_service_sp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampoAdicionalRequest {

    private String nombreCampo;
    private String valorCampo;

}
