package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucher;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentVoucherMapper {

    List<PaymentVoucherDto> listPaymentVoucherWithFilter(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    Integer countPaymentVoucher(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    List<PaymentVoucher> getTotalSoles(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

    int savePaymentVoucher(PaymentVoucher paymentVoucher);

    int updatePaymentVoucher(PaymentVoucher paymentVoucher);

    PaymentVoucher getPaymentVoucherById(@Param("id") Long idPaymentVoucher);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(
            @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("ruc") String ruc);

    public PaymentVoucher getPaymentVoucherByIdentificadorDocumento(@Param("idDocument") String identificadorDocumento);

    int updateStatePaymentVoucher1(@Param("id") Long idPaymentVoucher, @Param("codigo") String codigo,
                                   @Param("message") String messageResponse, @Param("codes") String codesResponse);

    int updateStatePaymentVoucher2(
            @Param("id") Long idPaymentVoucher, @Param("codigo") String codigo, @Param("esunat") String estadoEnSunat,
            @Param("message") String messageResponse, @Param("codes") String codesResponse);

    PaymentVoucher findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @Param("ruc") String rucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("numero") Integer numero
    );

    PaymentVoucherEntity findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            @Param("ruc") String finalRucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serieDocumento,
            @Param("numero") Integer numeroDocumento
    );

}
