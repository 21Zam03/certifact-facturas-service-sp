package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.exceptions.ServiceException;
import com.certicom.certifact_facturas_service_sp.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.model.OseDto;
import com.certicom.certifact_facturas_service_sp.mapper.EmpresaMapper;
import com.certicom.certifact_facturas_service_sp.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaMapper empresaMapper;

    @Override
    public String obtenerEstadoEmpresaPorRuc(String rucEmisor) {
        String estado = null;
        if (rucEmisor != null) {
            try {
                estado =  empresaMapper.obtenerEstadoEmpresaPorRuc(rucEmisor);
            } catch (Exception e) {
                log.error("ERROR: {}", e.getMessage());
            }
        } else {
            throw new ServiceException("rucEmisor is null");
        }
        return estado;
    }

    @Override
    public EmpresaDto obtenerEmpresaRuc(String ruc) {
        EmpresaDto empresa = null;
        if (ruc!= null) {
            try {
                empresa =  empresaMapper.obtenerEmpresaPorRuc(ruc);
            } catch (Exception e) {
                log.error("ERROR: {}", e.getMessage());
            }
        } else {
            throw new ServiceException("idUsuario is null");
        }
        return empresa;
    }

    @Override
    public OseDto findOseByRucInter(String ruc) {
        return empresaMapper.findOseByRucInter(ruc);
    }

}
