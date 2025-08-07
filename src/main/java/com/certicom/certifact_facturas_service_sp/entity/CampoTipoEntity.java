package com.certicom.certifact_facturas_service_sp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampoTipoEntity {

    private Long id;
    private String name;
    //private List<CompanyEntity> companys;

}
