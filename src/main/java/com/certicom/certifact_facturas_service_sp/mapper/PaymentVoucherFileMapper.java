package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherFileModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentVoucherFileMapper {

    int save(PaymentVoucherFileModel paymentVoucherFileModel);
    List<PaymentVoucherFileModel> listPaymentVoucherFiles(@Param("id") Long idPaymentVoucher);
    int update(PaymentVoucherFileModel paymentVoucherFileModel);

}
