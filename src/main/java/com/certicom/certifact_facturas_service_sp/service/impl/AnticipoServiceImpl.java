package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.AnticipoMapper;
import com.certicom.certifact_facturas_service_sp.service.AnticipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnticipoServiceImpl implements AnticipoService {

    private final AnticipoMapper anticipoMapper;

    @Override
    public int deleteAnticipoById(Long anticipoId) {
        return anticipoMapper.deleteAnticipoById(anticipoId);
    }

}
