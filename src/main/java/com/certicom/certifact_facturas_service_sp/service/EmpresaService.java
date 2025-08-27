package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.dto.model.OseDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmpresaService {

    public String obtenerEstadoEmpresaPorRuc(String rucEmisor);
    public EmpresaDto obtenerEmpresaRuc(String ruc);
    public OseDto findOseByRucInter(String ruc);

}
