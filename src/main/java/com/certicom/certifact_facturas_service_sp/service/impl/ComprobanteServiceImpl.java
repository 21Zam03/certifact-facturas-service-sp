package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteDto;
import com.certicom.certifact_facturas_service_sp.dto.others.Anticipo;
import com.certicom.certifact_facturas_service_sp.dto.others.CampoAdicional;
import com.certicom.certifact_facturas_service_sp.dto.others.CampoAdicionalComprobante;
import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteArchivo;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.mapper.*;
import com.certicom.certifact_facturas_service_sp.service.ComprobanteService;
import com.certicom.certifact_facturas_service_sp.util.UtilDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComprobanteServiceImpl implements ComprobanteService {

    private final ComprobanteMapper comprobanteMapper;
    private final ComprobanteArchivoMapper comprobanteArchivoMapper;
    private final AnticipoMapper anticipoMapper;
    private final CampoAdicionalMapper campoAdicionalMapper;
    private final CampoAdicionalComprobanteMapper campoAdicionalComprobanteMapper;

    @Override
    public List<ComprobanteDto> listarComprobantesConFiltro(
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
        return comprobanteMapper.listarComprobantesConFiltro(filtro);
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
        return comprobanteMapper.contarComprobantesConFiltro(filtro);
    }

    @Override
    public List<ComprobanteDto> obtenerTotalSolesGeneral(
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
        return comprobanteMapper.obtenerTotalSolesGeneralConFiltro(filtro);
    }

    @Transactional
    @Override
    public ComprobanteEntity registrarComprobante(ComprobanteDto comprobanteDto) {
        int result = comprobanteMapper.registrarComprobante(comprobanteDto);
        if(result == 0){
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        log.info("Resultado: {}", result);
        /*
        for (int i =0; i<comprobanteDto.getComprobanteArchivoList().size();i++) {
            ComprobanteArchivo comprobanteArchivo = ComprobanteArchivo.builder()
                    .tipoArchivo(comprobanteDto.getComprobanteArchivoList().get(i).getTipoArchivo())
                    .estadoArchivo(comprobanteDto.getComprobanteArchivoList().get(i).getEstadoArchivo())
                    .orden(comprobanteDto.getComprobanteArchivoList().get(i).getOrden())
                    .idPaymentVoucher(comprobanteDto.getId())
                    .subidaRegistroArchivoId(comprobanteDto.getComprobanteArchivoList().get(i).getSubidaRegistroArchivoId())
                    .build();
            result = comprobanteArchivoMapper.registrarComprobanteArchivo(comprobanteArchivo);
            if(result == 0){
                throw new RuntimeException("No se pudo registrar el comprobante archivo");
            }
        }

        if (comprobanteDto.getAnticipos() != null && !comprobanteDto.getAnticipos().isEmpty()) {
            for (int i = 0; i < comprobanteDto.getAnticipos().size(); i++) {
                Anticipo anticipo = Anticipo.builder()
                        .idPaymentVoucher(comprobanteDto.getId())
                        .serieAnticipo(comprobanteDto.getAnticipos().get(i).getSerieAnticipo())
                        .numeroAnticipo(comprobanteDto.getAnticipos().get(i).getNumeroAnticipo())
                        .tipoDocumentoAnticipo(comprobanteDto.getAnticipos().get(i).getTipoDocumentoAnticipo())
                        .montoAnticipado(comprobanteDto.getAnticipos().get(i).getMontoAnticipado())
                        .build();
                result = anticipoMapper.registrarAnticipo(anticipo);
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el anticipo");
                }
            }
        }

        if(comprobanteDto.getCamposAdicionales() != null && !comprobanteDto.getCamposAdicionales().isEmpty()) {
            for (int i = 0; i < comprobanteDto.getCamposAdicionales().size(); i++) {
                Long campoAdicionalId = campoAdicionalMapper.obtenerCampoAdicionalIdPorNombre(comprobanteDto.getCamposAdicionales().get(i).getNombreCampo());
                if (campoAdicionalId == null) {
                    throw new RuntimeException("Error al obtener el campo adicional");
                }
                CampoAdicionalComprobante campoAdicionalComprobante = CampoAdicionalComprobante.builder()
                        .valorCampo(comprobanteDto.getCamposAdicionales().get(i).getValorCampo())
                        .idComprobante(comprobanteDto.getId())
                        .idCampoAdicional(campoAdicionalId)
                        .build();
                result = campoAdicionalComprobanteMapper.registrarCampoAdicionalComprobante(campoAdicionalComprobante);
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }
        ComprobanteEntity comprobante = comprobanteMapper.obtenerComprobantePorId(comprobanteDto.getId());
        if(comprobante == null){
            throw new RuntimeException("Error al obtener comprobante");
        }

        * */
        return new ComprobanteEntity();
    }

}
