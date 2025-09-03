package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VoidedDocumentsMapper {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, @Param("fecha") String fechaGeneracionBaja);
    int save(VoidedDocuments voidedDocuments);
    int update(VoidedDocuments voidedDocuments);
    VoidedDocuments findVoidedDocumentsById(Long id);

}
