package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.converter.PaymentVoucherConverter;
import com.certicom.certifact_facturas_service_sp.dto.others.*;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_facturas_service_sp.entity.*;
import com.certicom.certifact_facturas_service_sp.mapper.*;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherService;
import com.certicom.certifact_facturas_service_sp.util.UtilDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    public List<PaymentVoucherModel> getTotalSoles(
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
    public PaymentVoucherModel savePaymentVoucher(PaymentVoucherModel paymentVoucherModel) {
        //paymentVoucherEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        //paymentVoucherEntity.setFechaEmisionDate(new Date());
        int result;
        if(paymentVoucherModel.getIdPaymentVoucher()!=null) {
            result = paymentVoucherMapper.updatePaymentVoucher(paymentVoucherModel);
            System.out.println("UPDATE");
        } else {
            result = paymentVoucherMapper.savePaymentVoucher(paymentVoucherModel);
        }
        if(result == 0){
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        log.info("Resultado: {}", result);
        log.info("ID: {}", paymentVoucherModel.getIdPaymentVoucher());

        //Proximamente registrar archivos desde aqui y no desde la capa de ng

        for (int i = 0; i< paymentVoucherModel.getPaymentVoucherFileModelList().size(); i++) {
            paymentVoucherModel.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            //Por ahora dejarlo asi, pero se tiene que integrar el metodo de inserccion de archivos a la base de datos en este mismo metodo [registrarComprobante]
            //paymentVoucherEntity.getComprobanteArchivoEntityList().get(i).setIdRegisterFileSend();
            result = paymentVoucherFileMapper.save(paymentVoucherModel.getPaymentVoucherFileModelList().get(i));
            if(result == 0){
                throw new RuntimeException("No se pudo registrar el comprobante archivo");
            }
        }

        if (paymentVoucherModel.getAnticipos() != null && !paymentVoucherModel.getAnticipos().isEmpty()) {
            for (int i = 0; i < paymentVoucherModel.getAnticipos().size(); i++) {
                paymentVoucherModel.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                result = anticipoMapper.registrarAnticipo(paymentVoucherModel.getAnticipos().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el anticipo");
                }
            }
        }

        if(paymentVoucherModel.getCamposAdicionales()!= null && !paymentVoucherModel.getCamposAdicionales().isEmpty()) {
            for (int i = 0; i < paymentVoucherModel.getCamposAdicionales().size(); i++) {
                paymentVoucherModel.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                Integer id = typeFieldMapper.getIdByName(paymentVoucherModel.getCamposAdicionales().get(i).getNombreCampo());
                paymentVoucherModel.getCamposAdicionales().get(i).setTypeFieldId(id);
                result = additionalFieldMapper.registrarCampoAdicionalComprobante(paymentVoucherModel.getCamposAdicionales().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar el campo adicional");
                }
            }
        }

        if (paymentVoucherModel.getCuotas() != null && !paymentVoucherModel.getCuotas().isEmpty()) {
            for (int i = 0; i< paymentVoucherModel.getCuotas().size(); i++) {
                //paymentVoucher.getCuotas().get(i).setNumero(i+1);
                paymentVoucherModel.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                result = cuotasPaymentVoucherMapper.registrarCuotaPaymentVoucher(paymentVoucherModel.getCuotas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la cuota");
                }
            }
        }

        if(paymentVoucherModel.getItems() != null && !paymentVoucherModel.getItems().isEmpty()) {
            for (int i = 0; i < paymentVoucherModel.getItems().size(); i++) {
                paymentVoucherModel.getItems().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                result = detailsPaymentVoucherMapper.registrarDetailsPaymentVoucher(paymentVoucherModel.getItems().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar los items");
                }
            }
        }

        if(paymentVoucherModel.getGuiasRelacionadas() != null && !paymentVoucherModel.getGuiasRelacionadas().isEmpty()) {
            for (int i = 0; i < paymentVoucherModel.getGuiasRelacionadas().size(); i++) {
                paymentVoucherModel.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                result = guiaPaymentVoucherMapper.saveGuiaPayment(paymentVoucherModel.getGuiasRelacionadas().get(i));
                if(result == 0){
                    throw new RuntimeException("No se pudo registrar la guia relacionada");
                }
            }
        }
        System.out.println("PASO");
        PaymentVoucherModel entity = paymentVoucherMapper.getPaymentVoucherById(paymentVoucherModel.getIdPaymentVoucher());
        System.out.println("entity"+ entity);
        if(entity == null){
            throw new RuntimeException("Error al obtener comprobante");
        }
        return entity;
    }

    @Override
    public PaymentVoucherModel findPaymentVoucherById(Long id) {
        return paymentVoucherMapper.getPaymentVoucherById(id);
    }

    @Override
    public Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc) {
        return paymentVoucherMapper.findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(tipoComprobante, serie, ruc);
    }

    @Override
    public PaymentVoucherModel getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento) {
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
    public int updateStatePaymentVoucher(List<String> identificadorComprobantes, String estadoPendienteAnulacion, String usuario, Timestamp fechaModificacion) {
        return paymentVoucherMapper.updateStatePaymentVoucher3(identificadorComprobantes, estadoPendienteAnulacion, usuario, fechaModificacion);
    }

    @Override
    public PaymentVoucherModel findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(String rucEmisor, String tipoComprobante, String serie, Integer numero) {
        PaymentVoucherModel paymentVoucherModel = paymentVoucherMapper.
                findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(rucEmisor, tipoComprobante, serie, numero);
        List<ComprobanteItem> items = detailsPaymentVoucherMapper.findByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
        List<CampoAdicional> aditionalFields = additionalFieldMapper.listAditionalFieldByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
        List<Anticipo> anticipos = anticipoMapper.listAnticiposByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
        List<ComprobanteCuota> cuotas = cuotasPaymentVoucherMapper.listCuotasByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
        List<GuiaRelacionada> guiasRelacionadas = guiaPaymentVoucherMapper.listGuiasByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());

        System.out.println("ITEMS: "+aditionalFields);
        paymentVoucherModel.setItems(items);
        paymentVoucherModel.setCamposAdicionales(aditionalFields);
        paymentVoucherModel.setAnticipos(anticipos);
        paymentVoucherModel.setCuotas(cuotas);
        paymentVoucherModel.setGuiasRelacionadas(guiasRelacionadas);
        return paymentVoucherModel;
    }

    @Override
    public PaymentVoucherModel findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
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
