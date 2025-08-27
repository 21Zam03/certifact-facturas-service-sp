package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.DetailsPaymentVoucherMapper;
import com.certicom.certifact_facturas_service_sp.service.DetailPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailPaymentServiceImpl implements DetailPaymentService {

    private final DetailsPaymentVoucherMapper detailPaymentVoucherMapper;

    @Override
    public int deleteDetailPaymentVoucherById(Long detailPaymentVoucherId) {
        return detailPaymentVoucherMapper.deleteDetailPaymentVoucherById(detailPaymentVoucherId);
    }


}
