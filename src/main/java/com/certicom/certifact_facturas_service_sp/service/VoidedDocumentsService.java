package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;

import java.sql.Timestamp;
import java.util.List;

public interface VoidedDocumentsService {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, String fechaGeneracionBaja);
    VoidedDocuments save(VoidedDocuments voidedDocuments);
    VoidedDocuments findByTicket(String ticket);
    String findEstadoByTicket(String ticket);
    VoidedDocuments update(VoidedDocuments voidedDocuments);

}
