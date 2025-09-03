package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.ParameterMapper;
import com.certicom.certifact_facturas_service_sp.model.Parameter;
import com.certicom.certifact_facturas_service_sp.service.ParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParameterServiceImpl implements ParameterService {

    private final ParameterMapper parameterMapper;

    @Override
    public Parameter findByName(String name) {
        return parameterMapper.findByName(name);
    }

}
