package com.certicom.certifact_facturas_service_sp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VoidedDocumentsMapper {

    Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, @Param("fecha") String fechaGeneracionBaja);

}
