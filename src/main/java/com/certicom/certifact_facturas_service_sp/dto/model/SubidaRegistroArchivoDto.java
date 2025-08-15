package com.certicom.certifact_facturas_service_sp.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubidaRegistroArchivoDto {

    private String bucket;
    private String nombreOriginal;
    private String nombreGenerado;
    private Integer codCompany;

}
