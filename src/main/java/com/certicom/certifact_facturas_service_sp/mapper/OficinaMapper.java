package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.OficinaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OficinaMapper {

    OficinaDto obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(
            @Param("codCompany") Integer empresaId, @Param("serie") String serie, @Param("tipoComprobante") String tipoComprobante
    );

}
