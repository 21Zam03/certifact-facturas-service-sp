package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteArchivo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComprobanteArchivoMapper {

    int registrarComprobanteArchivo(ComprobanteArchivo comprobanteArchivo);

}
