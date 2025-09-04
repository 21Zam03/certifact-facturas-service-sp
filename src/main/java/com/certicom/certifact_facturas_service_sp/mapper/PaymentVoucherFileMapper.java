package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherFileModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentVoucherFileMapper {

    int save(PaymentVoucherFileModel paymentVoucherFileModel);

}
