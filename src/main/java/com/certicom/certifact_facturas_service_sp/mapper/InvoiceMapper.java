package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvoiceMapper {

    List<ComprobanteInterDto> listarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    Integer contarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    List<ComprobanteInterDto> obtenerTotalSolesGeneralConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);

}
