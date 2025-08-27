package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
import org.apache.ibatis.annotations.Param;

public interface TmpVoucherSendBillService {

    TmpVoucherSendBillEntity findTmpVoucherByIdPaymentVoucher(Long id);
    int saveTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity);
    public int updateStatusVoucherTmp(Long identificador, String estado);
    public int deleteTmpVoucherById(Long id);

}
