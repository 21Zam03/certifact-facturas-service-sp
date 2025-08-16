package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.SubidaRegistroArchivoDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;

public interface SubidaRegistroArchivoService {

    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(SubidaRegistroArchivoDto subidaRegistroArchivoDto);

}
