package com.certicom.certifact_facturas_service_sp.service;

public interface VoidedDocumentsService {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, String fechaGeneracionBaja);

}
