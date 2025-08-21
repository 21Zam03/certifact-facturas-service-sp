package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;

public interface TmpVoucherSendBillService {

    TmpVoucherSendBillEntity findTmpVoucherByIdPaymentVoucher(Long id);
    int saveTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity);

}
