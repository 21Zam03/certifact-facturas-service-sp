package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.GuiaPaymentVoucherMapper;
import com.certicom.certifact_facturas_service_sp.service.GuiaPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuiaPaymentServiceImpl implements GuiaPaymentService {

    private final GuiaPaymentVoucherMapper guiaPaymentVoucherMapper;

    @Override
    public int deleteGuiaPaymentById(Long idGuiaPayment) {
        return guiaPaymentVoucherMapper.deleteGuiaPaymentById(idGuiaPayment);
    }

}
