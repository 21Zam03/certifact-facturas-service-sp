package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteFiltroDto;
import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentVoucherMapper {

    List<ComprobanteDto> listarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    Integer contarComprobantesConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    List<ComprobanteDto> obtenerTotalSolesGeneralConFiltro(@Param("filtro") ComprobanteFiltroDto comprobanteFiltroDto);
    int registrarComprobante(PaymentVoucherEntity paymentVoucherEntity);
    PaymentVoucherEntity getPaymentVoucherById(@Param("id") Long idPaymentVoucher);

}
