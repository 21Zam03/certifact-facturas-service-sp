package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ComprobanteMapper {

    List<ComprobanteDto> listarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    Integer contarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    List<ComprobanteDto> obtenerTotalSolesGeneralConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    int registrarComprobante(ComprobanteDto comprobanteDto);
    ComprobanteEntity obtenerComprobantePorId(@Param("id") Long idComprobante);

}
