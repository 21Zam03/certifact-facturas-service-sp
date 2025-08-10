package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.mapper.InvoiceMapper;
import com.certicom.certifact_facturas_service_sp.service.ComprobanteService;
import com.certicom.certifact_facturas_service_sp.util.UtilDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComprobanteServiceImpl implements ComprobanteService {

    private final InvoiceMapper invoiceMapper;

    @Override
    public List<ComprobanteInterDto> listarComprobantesConFiltro(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {

        ComprobanteFiltroDto filtro = ComprobanteFiltroDto.builder()
                .rucEmisor(rucEmisor)
                .filtroDesde(UtilDate.stringToDate(filtroDesde, "dd-MM-yyyy"))
                .filtroHasta(UtilDate.stringToDate(filtroHasta, "dd-MM-yyyy"))
                .filtroTipoComprobante(filtroTipoComprobante.trim().isEmpty() ? null : filtroTipoComprobante)
                .filtroRuc("%"+filtroRuc+"%")
                .filtroSerie("%"+filtroSerie+"%")
                .filtroNumero(filtroNumero)
                .idOficina(idOficina)
                .estadoSunat("%"+estadoSunat+"%")
                .numPagina(pageNumber)
                .porPagina(perPage)
                .build();
        return invoiceMapper.listarComprobantesConFiltro(filtro);
    }

    @Override
    public Integer contarComprobantes(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {
        ComprobanteFiltroDto filtro = ComprobanteFiltroDto.builder()
                .rucEmisor(rucEmisor)
                .filtroDesde(UtilDate.stringToDate(filtroDesde, "dd-MM-yyyy"))
                .filtroHasta(UtilDate.stringToDate(filtroHasta, "dd-MM-yyyy"))
                .filtroTipoComprobante(filtroTipoComprobante.trim().isEmpty() ? null : filtroTipoComprobante)
                .filtroRuc("%"+filtroRuc+"%")
                .filtroSerie("%"+filtroSerie+"%")
                .filtroNumero(filtroNumero)
                .idOficina(idOficina)
                .estadoSunat("%"+estadoSunat+"%")
                .numPagina(pageNumber)
                .porPagina(perPage)
                .build();
        return invoiceMapper.contarComprobantesConFiltro(filtro);
    }

    @Override
    public List<ComprobanteInterDto> obtenerTotalSolesGeneral(
            String rucEmisor, String filtroDesde, String filtroHasta, String filtroTipoComprobante, String filtroRuc, String filtroSerie,
            Integer filtroNumero, Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {
        ComprobanteFiltroDto filtro = ComprobanteFiltroDto.builder()
                .rucEmisor(rucEmisor)
                .filtroDesde(UtilDate.stringToDate(filtroDesde, "dd-MM-yyyy"))
                .filtroHasta(UtilDate.stringToDate(filtroHasta, "dd-MM-yyyy"))
                .filtroTipoComprobante(filtroTipoComprobante.trim().isEmpty() ? null : filtroTipoComprobante)
                .filtroRuc("%"+filtroRuc+"%")
                .filtroSerie("%"+filtroSerie+"%")
                .filtroNumero(filtroNumero)
                .idOficina(idOficina)
                .estadoSunat("%"+estadoSunat+"%")
                .numPagina(pageNumber)
                .porPagina(perPage)
                .build();
        return invoiceMapper.obtenerTotalSolesGeneralConFiltro(filtro);
    }

}
