package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.VoidedDocumentsMapper;
import com.certicom.certifact_facturas_service_sp.service.VoidedDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoidedDocumentsServiceImpl implements VoidedDocumentsService {

    private final VoidedDocumentsMapper voidedDocumentsMapper;

    @Override
    public Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, String fechaGeneracionBaja) {
        return voidedDocumentsMapper.getCorrelativoGeneracionByDiaInVoidedDocuments(ruc, fechaGeneracionBaja);
    }

}
