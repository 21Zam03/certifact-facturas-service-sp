package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubidaRegistroArchivoMapper {

    SubidaRegistroArchivoEntity regitrarSubidaArchivo();

}
