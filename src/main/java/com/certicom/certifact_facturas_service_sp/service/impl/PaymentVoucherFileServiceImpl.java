package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_facturas_service_sp.mapper.PaymentVoucherFileMapper;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentVoucherFileServiceImpl implements PaymentVoucherFileService {

    private final PaymentVoucherFileMapper paymentVoucherFileMapper;

    @Override
    public int save(PaymentVoucherFileModel paymentVoucherFileModel) {
        return paymentVoucherFileMapper.save(paymentVoucherFileModel);
    }
}
