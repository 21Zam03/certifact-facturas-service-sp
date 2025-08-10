package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ComprobanteService {

    List<ComprobanteInterDto> listarComprobantesConFiltro(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    Integer contarComprobantes(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    List<ComprobanteInterDto> obtenerTotalSolesGeneral(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );


}
