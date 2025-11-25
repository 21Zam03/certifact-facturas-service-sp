package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.DetailsDocsVoided;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsDocsVoidedMapper {

    int save(DetailsDocsVoided detailsDocsVoided);
    List<DetailsDocsVoided> findByIdDocsVoided(Long idDocsVoided);
}
