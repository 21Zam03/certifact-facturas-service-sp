package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.converter.PaymentVoucherConverter;
import com.certicom.certifact_facturas_service_sp.dto.others.*;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucher;
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
    private final TypeFieldMapper typeFieldMapper;
    private final AdditionalFieldMapper additionalFieldMapper;
    private final CuotasPaymentVoucherMapper cuotasPaymentVoucherMapper;
    private final DetailsPaymentVoucherMapper detailsPaymentVoucherMapper;
    private final GuiaPaymentVoucherMapper guiaPaymentVoucherMapper;


    @Override
    public List<PaymentVoucherDto> listPaymentVoucherWithFilter(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {
        PaymentVoucherFilterDto filtro = PaymentVoucherFilterDto.builder()
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
        return paymentVoucherMapper.listPaymentVoucherWithFilter(filtro);
    }

    @Override
    public Integer countPaymentVoucher(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {
        PaymentVoucherFilterDto filtro = PaymentVoucherFilterDto.builder()
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
        return paymentVoucherMapper.countPaymentVoucher(filtro);
    }

    @Override
    public List<PaymentVoucher> getTotalSoles(
            String rucEmisor, String filtroDesde, String filtroHasta, String filtroTipoComprobante, String filtroRuc, String filtroSerie,
            Integer filtroNumero, Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    ) {
        PaymentVoucherFilterDto filtro = PaymentVoucherFilterDto.builder()
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
        return paymentVoucherMapper.getTotalSoles(filtro);
    }

    @Transactional
    @Override
    public PaymentVoucher savePaymentVoucher(PaymentVoucher paymentVoucher) {
        //paymentVoucherEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        //paymentVoucherEntity.setFechaEmisionDate(new Date());
        int result;
        if(paymentVoucher.getIdPaymentVoucher()!=null) {
            result = paymentVoucherMapper.updatePaymentVoucher(paymentVoucher);
        } else {
            result = paymentVoucherMapper.savePaymentVoucher(paymentVoucher);
        }
        if(result == 0){
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        log.info("Resultado: {}", result);
        log.info("ID: {}", paymentVoucher.getIdPaymentVoucher());

        //Proximamente registrar archivos desde aqui y no desde la capa de ng

        for (int i =0; i<paymentVoucher.getPaymentVoucherFileList().size();i++) {
            paymentVoucher.getPaymentVoucherFileList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
            //Por ahora dejarlo asi, pero se tiene que integrar el metodo de inserccion de archivos a la base de datos en este mismo metodo [registrarComprobante]
            //paymentVoucherEntity.getComprobanteArchivoEntityList().get(i).setIdRegisterFileSend();
            result = paymentVoucherFileMapper.save(paymentVoucher.getPaymentVoucherFileList().get(i));
            if(result == 0){
                throw new RuntimeException("No se pudo registrar el comprobante archivo");
            }
        }

        if (paymentVoucher.getAnticipos() != null && !paymentVoucher.getAnticipos().isEmpty()) {
            for (int i = 0; i < paymentVoucher.getAnticipos().size(); i++) {
                paymentVoucher.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = anticipoMapper.registrarAnticipo(paymentVoucher.getAnticipos().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el anticipo");
                }
            }
        }

        if(paymentVoucher.getCamposAdicionales()!= null && !paymentVoucher.getCamposAdicionales().isEmpty()) {
            for (int i = 0; i < paymentVoucher.getCamposAdicionales().size(); i++) {
                paymentVoucher.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                Integer id = typeFieldMapper.getIdByName(paymentVoucher.getCamposAdicionales().get(i).getNombreCampo());
                paymentVoucher.getCamposAdicionales().get(i).setTypeFieldId(id);
                result = additionalFieldMapper.registrarCampoAdicionalComprobante(paymentVoucher.getCamposAdicionales().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }

        if (paymentVoucher.getCuotas() != null && !paymentVoucher.getCuotas().isEmpty()) {
            for (int i=0; i<paymentVoucher.getCuotas().size(); i++) {
                //paymentVoucher.getCuotas().get(i).setNumero(i+1);
                paymentVoucher.getCuotas().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = cuotasPaymentVoucherMapper.registrarCuotaPaymentVoucher(paymentVoucher.getCuotas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la cuota");
                }
            }
        }

        if(paymentVoucher.getItems() != null && !paymentVoucher.getItems().isEmpty()) {
            for (int i = 0; i < paymentVoucher.getItems().size(); i++) {
                paymentVoucher.getItems().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = detailsPaymentVoucherMapper.registrarDetailsPaymentVoucher(paymentVoucher.getItems().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar los items");
                }
            }
        }

        if(paymentVoucher.getGuiasRelacionadas() != null && !paymentVoucher.getGuiasRelacionadas().isEmpty()) {
            for (int i = 0; i < paymentVoucher.getGuiasRelacionadas().size(); i++) {
                paymentVoucher.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = guiaPaymentVoucherMapper.saveGuiaPayment(paymentVoucher.getGuiasRelacionadas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la guia relacionada");
                }
            }
        }

        PaymentVoucher entity = paymentVoucherMapper.getPaymentVoucherById(paymentVoucher.getIdPaymentVoucher());
        if(entity == null){
            throw new RuntimeException("Error al obtener comprobante");
        }
        return entity;
    }

    @Override
    public PaymentVoucher findPaymentVoucherById(Long id) {
        return paymentVoucherMapper.getPaymentVoucherById(id);
    }

    @Override
    public Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc) {
        return paymentVoucherMapper.findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(tipoComprobante, serie, ruc);
    }

    @Override
    public PaymentVoucher getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento) {
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
    public PaymentVoucher findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(String rucEmisor, String tipoComprobante, String serie, Integer numero) {
        PaymentVoucher paymentVoucher = paymentVoucherMapper.
                findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(rucEmisor, tipoComprobante, serie, numero);
        List<ComprobanteItem> items = detailsPaymentVoucherMapper.findByIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
        List<CampoAdicional> aditionalFields = additionalFieldMapper.listAditionalFieldByIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
        List<Anticipo> anticipos = anticipoMapper.listAnticiposByIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
        List<ComprobanteCuota> cuotas = cuotasPaymentVoucherMapper.listCuotasByIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
        List<GuiaRelacionada> guiasRelacionadas = guiaPaymentVoucherMapper.listGuiasByIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());

        System.out.println("ITEMS: "+aditionalFields);
        paymentVoucher.setItems(items);
        paymentVoucher.setCamposAdicionales(aditionalFields);
        paymentVoucher.setAnticipos(anticipos);
        paymentVoucher.setCuotas(cuotas);
        paymentVoucher.setGuiasRelacionadas(guiasRelacionadas);
        return paymentVoucher;
    }

    @Override
    public PaymentVoucher findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
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
