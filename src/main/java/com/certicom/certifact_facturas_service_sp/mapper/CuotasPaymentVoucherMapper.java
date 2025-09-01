package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteCuota;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CuotasPaymentVoucherMapper {

    int registrarCuotaPaymentVoucher(ComprobanteCuota cuotasPaymentVoucherEntity);
    int deletePaymentCuotasById(Long idCuota);
    List<ComprobanteCuota> listCuotasByIdPaymentVoucher(@Param("id") Long idPaymentVoucher);
}
