package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailCompanyNotifyModel {

    private Long id;
    private String email;
    private boolean estado;
    private Long codCompany;

}
