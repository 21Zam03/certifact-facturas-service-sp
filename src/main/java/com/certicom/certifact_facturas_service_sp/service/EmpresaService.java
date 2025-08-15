package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.EmpresaDto;

public interface EmpresaService {

    public String obtenerEstadoEmpresaPorRuc(String rucEmisor);
    public EmpresaDto obtenerEmpresaRuc(String ruc);

}
