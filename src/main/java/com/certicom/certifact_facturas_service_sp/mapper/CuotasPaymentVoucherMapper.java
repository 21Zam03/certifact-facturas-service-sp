package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteCuota;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CuotasPaymentVoucherMapper {

    int registrarCuotaPaymentVoucher(ComprobanteCuota cuotasPaymentVoucherEntity);
    int deletePaymentCuotasById(Long idCuota);

}
