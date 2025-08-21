package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.*;
import com.certicom.certifact_facturas_service_sp.mapper.*;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherService;
import com.certicom.certifact_facturas_service_sp.util.UtilDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherServiceImpl implements PaymentVoucherService {

    private final PaymentVoucherMapper paymentVoucherMapper;
    private final ComprobanteArchivoMapper comprobanteArchivoMapper;
    private final AnticipoMapper anticipoMapper;
    private final CampoAdicionalMapper campoAdicionalMapper;
    private final AdditionalFieldMapper additionalFieldMapper;
    private final CuotasPaymentVoucherMapper cuotasPaymentVoucherMapper;
    private final DetailsPaymentVoucherMapper detailsPaymentVoucherMapper;

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
    public PaymentVoucherEntity registrarComprobante(PaymentVoucherEntity paymentVoucherEntity) {
        paymentVoucherEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        paymentVoucherEntity.setFechaEmisionDate(new Date());

        int result = paymentVoucherMapper.registrarComprobante(paymentVoucherEntity);
        if(result == 0){
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        log.info("Resultado: {}", result);
        log.info("ID: {}", paymentVoucherEntity.getIdPaymentVoucher());

        //Proximamente registrar archivos desde aqui y no desde la capa de ng

        for (int i =0; i<paymentVoucherEntity.getComprobanteArchivoEntityList().size();i++) {
            paymentVoucherEntity.getComprobanteArchivoEntityList().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
            //Por ahora dejarlo asi, pero se tiene que integrar el metodo de inserccion de archivos a la base de datos en este mismo metodo [registrarComprobante]
            //paymentVoucherEntity.getComprobanteArchivoEntityList().get(i).setIdRegisterFileSend();
            result = comprobanteArchivoMapper.registrarComprobanteArchivo(paymentVoucherEntity.getComprobanteArchivoEntityList().get(i));
            if(result == 0){
                throw new RuntimeException("No se pudo registrar el comprobante archivo");
            }
        }

        if (paymentVoucherEntity.getAnticipoEntityList() != null && !paymentVoucherEntity.getAnticipoEntityList().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getAnticipoEntityList().size(); i++) {
                paymentVoucherEntity.getAnticipoEntityList().get(i).setIdpaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = anticipoMapper.registrarAnticipo(paymentVoucherEntity.getAnticipoEntityList().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el anticipo");
                }
            }
        }

        if(paymentVoucherEntity.getComprobanteCampoAdicionalEntityList() != null && !paymentVoucherEntity.getComprobanteCampoAdicionalEntityList().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getComprobanteCampoAdicionalEntityList().size(); i++) {
                paymentVoucherEntity.getComprobanteCampoAdicionalEntityList().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = additionalFieldMapper.registrarCampoAdicionalComprobante(paymentVoucherEntity.getComprobanteCampoAdicionalEntityList().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }

        if (paymentVoucherEntity.getCuotasEntityList() != null && !paymentVoucherEntity.getCuotasEntityList().isEmpty()) {
            for (int i=0; i<paymentVoucherEntity.getCuotasEntityList().size(); i++) {
                paymentVoucherEntity.getCuotasEntityList().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = cuotasPaymentVoucherMapper.registrarCuotaPaymentVoucher(paymentVoucherEntity.getCuotasEntityList().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }

        if(paymentVoucherEntity.getComprobanteDetalleEntityList() != null && !paymentVoucherEntity.getComprobanteDetalleEntityList().isEmpty()) {
            for (int i = 0; i < paymentVoucherEntity.getComprobanteDetalleEntityList().size(); i++) {
                paymentVoucherEntity.getComprobanteDetalleEntityList().get(i).setIdPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher());
                result = detailsPaymentVoucherMapper.registrarDetailsPaymentVoucher(paymentVoucherEntity.getComprobanteDetalleEntityList().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
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

}
