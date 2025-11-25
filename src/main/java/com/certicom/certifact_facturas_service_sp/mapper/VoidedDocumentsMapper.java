package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface VoidedDocumentsMapper {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, @Param("fecha") String fechaGeneracionBaja);
    int save(VoidedDocuments voidedDocuments);
    int update(VoidedDocuments voidedDocuments);
    VoidedDocuments findVoidedDocumentsById(Long id);
    VoidedDocuments findByTicket(String ticket);
    String findEstadoByTicket(String ticket);

}
