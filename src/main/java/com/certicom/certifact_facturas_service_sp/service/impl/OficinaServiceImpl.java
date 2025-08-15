package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.OficinaDto;
import com.certicom.certifact_facturas_service_sp.mapper.OficinaMapper;
import com.certicom.certifact_facturas_service_sp.service.OficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OficinaServiceImpl implements OficinaService {

    private final OficinaMapper oficinaMapper;

    @Override
    public OficinaDto obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(Integer empresaId, String serie, String tipoComprobante) {
        return oficinaMapper.obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(empresaId, serie, tipoComprobante);
    }

}
