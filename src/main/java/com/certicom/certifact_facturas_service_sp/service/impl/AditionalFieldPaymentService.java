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
    public int deleteAditionalFieldPaymentById(Long aditionalFieldId) {
        return additionalFieldMapper.deleteAditionalFieldPaymentById(aditionalFieldId);
    }

}
