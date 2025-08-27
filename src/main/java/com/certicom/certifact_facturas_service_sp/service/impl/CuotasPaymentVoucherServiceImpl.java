package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.CuotasPaymentVoucherMapper;
import com.certicom.certifact_facturas_service_sp.service.CuotasPaymentVoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuotasPaymentVoucherServiceImpl implements CuotasPaymentVoucherService {

    private final CuotasPaymentVoucherMapper  cuotasPaymentVoucherMapper;

    @Override
    public int deletePaymentCuotasById(Long idCuota) {
        return cuotasPaymentVoucherMapper.deletePaymentCuotasById(idCuota);
    }

}
