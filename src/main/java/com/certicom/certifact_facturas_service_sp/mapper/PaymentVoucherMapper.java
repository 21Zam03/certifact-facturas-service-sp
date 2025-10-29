package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PaymentVoucherMapper {

    List<PaymentVoucherDto> listPaymentVoucherWithFilter(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    Integer countPaymentVoucher(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    List<PaymentVoucherModel> getTotalSoles(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    int savePaymentVoucher(PaymentVoucherModel paymentVoucherModel);

    int updatePaymentVoucher(PaymentVoucherModel paymentVoucherModel);

    PaymentVoucherModel getPaymentVoucherById(@Param("id") Long idPaymentVoucher);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(
            @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("ruc") String ruc);

    public PaymentVoucherModel getPaymentVoucherByIdentificadorDocumento(@Param("idDocument") String identificadorDocumento);

    int updateStatePaymentVoucher1(@Param("id") Long idPaymentVoucher, @Param("codigo") String codigo,
                                   @Param("message") String messageResponse, @Param("codes") String codesResponse);

    int updateStatePaymentVoucher2(
            @Param("id") Long idPaymentVoucher, @Param("codigo") String codigo, @Param("esunat") String estadoEnSunat,
            @Param("message") String messageResponse, @Param("codes") String codesResponse);

    int updateStatePaymentVoucher3(
            List<String> identificadorComprobantes, String estadoPendienteAnulacion,
            String usuario, Timestamp fechaModificacion);

    PaymentVoucherModel findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @Param("ruc") String rucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("numero") Integer numero
    );

    PaymentVoucherEntity findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            @Param("ruc") String finalRucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serieDocumento,
            @Param("numero") Integer numeroDocumento
    );

    Integer getUltimoNumero(
            @Param("tipo") String tipoComprobante,
            @Param("serie") String serieDocumento,
            @Param("ruc") String finalRucEmisor
    );

    List<PaymentVoucherModel> findAnticipos(
            @Param("tipoComprobante") List<String> tipoComprobante,
            @Param("numDocIdentReceptor") String numDocIdentReceptor,
            @Param("rucEmisor") String rucEmisor,
            @Param("tipoOperacion") String tipoOperacion,
            @Param("estado") String estado
    );

    List<PaymentVoucherModel> findCreditos(
            @Param("numDocIdentReceptor") String numDocIdentReceptor,
            @Param("rucEmisor") String rucEmisor
    );

    List<PaymentVoucherModel> findByIdPaymentVoucherInterList(
            @Param("ids") List<Long> ids
    );

}
