package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface TmpVoucherSendBillMapper {

    TmpVoucherSendBillEntity findTmpVoucherByIdPaymentVoucher(Long id);
    int saveTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity);
    public int updateStatusVoucherTmp(@Param("id") Long identificador, @Param("estado") String estado);
    public int deleteTmpVoucherById(@Param("id") Long id);
    int updateTmpVoucher(TmpVoucherSendBillEntity tmpVoucherSendBillEntity);

}
