package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.AdditionalFieldMapper;
import com.certicom.certifact_facturas_service_sp.service.AditionalFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AditionalFieldPaymentService implements AditionalFieldService {

    private final AdditionalFieldMapper additionalFieldMapper;

    @Override
    public int findAditionalFieldIdByValorCampo(String valorCampo) {
        return additionalFieldMapper.findAditionalFieldIdByValorCampo(valorCampo);
    }

    @Override
    public int deleteAditionalFieldPaymentById(Long aditionalFieldId) {
        return additionalFieldMapper.deleteAditionalFieldPaymentById(aditionalFieldId);
    }
}
