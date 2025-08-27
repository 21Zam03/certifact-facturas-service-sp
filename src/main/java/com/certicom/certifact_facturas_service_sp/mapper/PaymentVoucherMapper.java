package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PaymentVoucherMapper {

    List<PaymentVoucherDto> listarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);

    Integer contarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);

    List<PaymentVoucherDto> obtenerTotalSolesGeneralConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);

    int registrarComprobante(PaymentVoucherDto paymentVoucherDto);

    int updatePaymentVoucher(PaymentVoucherDto paymentVoucherDto);

    PaymentVoucherEntity getPaymentVoucherById(@Param("id") Long idPaymentVoucher);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(
            @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("ruc") String ruc);

    public PaymentVoucherEntity getPaymentVoucherByIdentificadorDocumento(@Param("idDocument") String identificadorDocumento);

    int updateStatePaymentVoucher1(@Param("id") Long idPaymentVoucher, @Param("codigo") String codigo,
                                   @Param("message") String messageResponse, @Param("codes") String codesResponse);

    int updateStatePaymentVoucher2(
            @Param("id") Long idPaymentVoucher, @Param("codigo") String codigo, @Param("esunat") String estadoEnSunat,
            @Param("message") String messageResponse, @Param("codes") String codesResponse);

    PaymentVoucherDto findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @Param("ruc") String rucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serie, @Param("numero") Integer numero
    );

    PaymentVoucherEntity findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            @Param("ruc") String finalRucEmisor, @Param("tipo") String tipoComprobante, @Param("serie") String serieDocumento,
            @Param("numero") Integer numeroDocumento
    );

}
