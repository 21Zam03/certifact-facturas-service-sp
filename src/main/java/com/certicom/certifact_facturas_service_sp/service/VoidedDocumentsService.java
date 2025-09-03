package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;

public interface VoidedDocumentsService {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, String fechaGeneracionBaja);
    VoidedDocuments save(VoidedDocuments voidedDocuments);

}
