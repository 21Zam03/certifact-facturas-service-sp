package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
import com.certicom.certifact_facturas_service_sp.mapper.TmpVoucherSendBillMapper;
import com.certicom.certifact_facturas_service_sp.service.TmpVoucherSendBillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TmpVoucherSendBillServiceImpl implements TmpVoucherSendBillService {

    private final TmpVoucherSendBillMapper tmpVoucherSendBillMapper;

    @Override
    public TmpVoucherSendBillEntity findTmpVoucherByIdPaymentVoucher(Long id) {
        TmpVoucherSendBillEntity tmpVoucherSendBillEntity = null;
        try {
            tmpVoucherSendBillEntity = tmpVoucherSendBillMapper.findTmpVoucherByIdPaymentVoucher(id);
        } catch (Exception e) {
            log.error("ERROR en TmpVoucherSendBillServiceImpl[findTmpVoucherByIdPaymentVoucher]: {}",e.getMessage());
        }
        return tmpVoucherSendBillEntity;
    }

    @Override
    public int saveTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity) {
        int result = 0;
        try {
            result = tmpVoucherSendBillMapper.saveTmpVoucher(tmpVoucherSendBillEntity);
        } catch (Exception e) {
            log.error("ERROR en TmpVoucherSendBillServiceImpl[saveTmpVoucher]: {}", e.getMessage());
        }
        return result;
    }

}
