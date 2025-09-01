package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.model.OseDto;

public interface EmpresaService {

    public String obtenerEstadoEmpresaPorRuc(String rucEmisor);
    public EmpresaDto obtenerEmpresaRuc(String ruc);
    public OseDto findOseByRucInter(String ruc);

}
