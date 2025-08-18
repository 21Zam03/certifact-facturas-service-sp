package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampoAdicional {

    private Integer id;
    private String nombreCampo;
    private String valorCampo;

}
