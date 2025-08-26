package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.entity.DetailsPaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsPaymentVoucherMapper {

    int registrarDetailsPaymentVoucher(DetailsPaymentVoucherEntity detailsPaymentVoucher);

    List<DetailsPaymentVoucherEntity> getListById();
}
