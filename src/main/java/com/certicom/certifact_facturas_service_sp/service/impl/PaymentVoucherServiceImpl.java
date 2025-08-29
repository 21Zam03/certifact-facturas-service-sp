package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.converter.PaymentVoucherConverter;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteItem;
import com.certicom.certifact_facturas_service_sp.entity.*;
import com.certicom.certifact_facturas_service_sp.mapper.*;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherService;
import com.certicom.certifact_facturas_service_sp.util.UtilDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherServiceImpl implements PaymentVoucherService {

    private final PaymentVoucherMapper paymentVoucherMapper;
    private final PaymentVoucherFileMapper paymentVoucherFileMapper;
    private final AnticipoMapper anticipoMapper;
    private final CampoAdicionalMapper campoAdicionalMapper;
    private final AdditionalFieldMapper additionalFieldMapper;
    private final CuotasPaymentVoucherMapper cuotasPaymentVoucherMapper;
    private final DetailsPaymentVoucherMapper detailsPaymentVoucherMapper;
    private final GuiaPaymentVoucherMapper guiaPaymentVoucherMapper;

    @Override
    public List<PaymentVoucherDto> listarComprobantesConFiltro(
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
        return paymentVoucherMapper.listarComprobantesConFiltro(filtro);
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
        return paymentVoucherMapper.contarComprobantesConFiltro(filtro);
    }

    @Override
    public List<PaymentVoucherDto> obtenerTotalSolesGeneral(
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
        return paymentVoucherMapper.obtenerTotalSolesGeneralConFiltro(filtro);
    }

    @Transactional
    @Override
    public PaymentVoucherEntity registrarComprobante(PaymentVoucherDto paymentVoucherEntity) {
        //paymentVoucherEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        //paymentVoucherEntity.setFechaEmisionDate(new Date());
        int result;
        if(paymentVoucherEntity.getIdPaymentVoucher()!=null) {
            result = paymentVoucherMapper.updatePaymentVoucher(paymentVoucherEntity);
        } else {
            result = paymentVoucherMapper.registrarComprobante(paymentVoucherEntity);
        }
        if(result == 0){
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        log.info("Resultado: {}", result);
        log.info("ID: {}", paymentVoucherEntity.getIdPaymentVoucher());

        //Proximamente registrar archivos desde aqui y no desde la capa de ng

        for (int i =0; i<paymentVoucherEntity.getPaymentVoucherFileList().size();i++) {
            paymentVoucherEntity.getPaymentVoucherFileList().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
            //Por ahora dejarlo asi, pero se tiene que integrar el metodo de inserccion de archivos a la base de datos en este mismo metodo [registrarComprobante]
            //paymentVoucherEntity.getComprobanteArchivoEntityList().get(i).setIdRegisterFileSend();
            result = paymentVoucherFileMapper.save(paymentVoucherEntity.getPaymentVoucherFileList().get(i));
            if(result == 0){
                throw new RuntimeException("No se pudo registrar el comprobante archivo");
            }
        }

        if (paymentVoucherEntity.getAnticipos() != null && !paymentVoucherEntity.getAnticipos().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getAnticipos().size(); i++) {
                paymentVoucherEntity.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = anticipoMapper.registrarAnticipo(paymentVoucherEntity.getAnticipos().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el anticipo");
                }
            }
        }

        if(paymentVoucherEntity.getCamposAdicionales()!= null && !paymentVoucherEntity.getCamposAdicionales().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getCamposAdicionales().size(); i++) {
                paymentVoucherEntity.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = additionalFieldMapper.registrarCampoAdicionalComprobante(paymentVoucherEntity.getCamposAdicionales().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }

        if (paymentVoucherEntity.getCuotas() != null && !paymentVoucherEntity.getCuotas().isEmpty()) {
            for (int i=0; i<paymentVoucherEntity.getCuotas().size(); i++) {
                paymentVoucherEntity.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = cuotasPaymentVoucherMapper.registrarCuotaPaymentVoucher(paymentVoucherEntity.getCuotas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la cuota");
                }
            }
        }

        if(paymentVoucherEntity.getItems() != null && !paymentVoucherEntity.getItems().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getItems().size(); i++) {
                paymentVoucherEntity.getItems().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = detailsPaymentVoucherMapper.registrarDetailsPaymentVoucher(paymentVoucherEntity.getItems().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar los items");
                }
            }
        }

        if(paymentVoucherEntity.getGuiasRelacionadas() != null && !paymentVoucherEntity.getGuiasRelacionadas().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getGuiasRelacionadas().size(); i++) {
                paymentVoucherEntity.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = guiaPaymentVoucherMapper.saveGuiaPayment(paymentVoucherEntity.getGuiasRelacionadas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la guia relacionada");
                }
            }
        }

        PaymentVoucherEntity entity = paymentVoucherMapper.getPaymentVoucherById(paymentVoucherEntity.getIdPaymentVoucher());
        if(entity == null){
            throw new RuntimeException("Error al obtener comprobante");
        }
        return entity;
    }

    @Override
    public PaymentVoucherEntity findPaymentVoucherById(Long id) {
        return paymentVoucherMapper.getPaymentVoucherById(id);
    }

    @Override
    public Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc) {
        return paymentVoucherMapper.findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(tipoComprobante, serie, ruc);
    }

    @Override
    public PaymentVoucherEntity getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento) {
        return paymentVoucherMapper.getPaymentVoucherByIdentificadorDocumento(identificadorDocumento);
    }

    @Override
    public int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String messageResponse, String codesResponse) {
        return paymentVoucherMapper.updateStatePaymentVoucher1(idPaymentVoucher, codigo, messageResponse, codesResponse);
    }

    @Override
    public int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String estadoEnSunat, String messageResponse, String codesResponse) {
        return paymentVoucherMapper.updateStatePaymentVoucher2(idPaymentVoucher, codigo, estadoEnSunat, messageResponse, codesResponse);
    }

    @Override
    public PaymentVoucherDto findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(String rucEmisor, String tipoComprobante, String serie, Integer numero) {
        PaymentVoucherDto paymentVoucherDto = paymentVoucherMapper.
                findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(rucEmisor, tipoComprobante, serie, numero);
        List<ComprobanteItem> items = detailsPaymentVoucherMapper.findByIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
        System.out.println("ITEMS: "+items);
        paymentVoucherDto.setItems(items);
        return paymentVoucherDto;
    }

    @Override
    public PaymentVoucherDto findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            String finalRucEmisor, String tipoComprobante, String serieDocumento, Integer numeroDocumento) {
        try {
            PaymentVoucherEntity paymentVoucherEntity = paymentVoucherMapper.findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
                    finalRucEmisor, tipoComprobante, serieDocumento, numeroDocumento
            );
            if(paymentVoucherEntity != null) {
                return PaymentVoucherConverter.entityToDto(paymentVoucherEntity);
            }
        } catch (Exception e) {
            log.info("ERROR: {}", e.getMessage());
        }
        return null;
    }

}
