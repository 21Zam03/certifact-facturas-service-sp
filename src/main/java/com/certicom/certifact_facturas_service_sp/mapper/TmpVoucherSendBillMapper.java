package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TmpVoucherSendBillMapper {

    TmpVoucherSendBillEntity findTmpVoucherByIdPaymentVoucher(Long id);
    int saveTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity);

}
