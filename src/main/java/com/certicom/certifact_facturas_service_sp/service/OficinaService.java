package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.OficinaDto;

public interface OficinaService {

    public OficinaDto obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(Integer empresaId, String serie, String tipoComprobante);

}
