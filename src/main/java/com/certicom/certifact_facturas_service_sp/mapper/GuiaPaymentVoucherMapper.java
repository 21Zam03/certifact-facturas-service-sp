package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.GuiaRelacionada;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GuiaPaymentVoucherMapper {

    int saveGuiaPayment(GuiaRelacionada guiaRelacionada);
    int deleteGuiaPaymentById(@Param("id") Long idGuiaPayment);
    List<GuiaRelacionada> listGuiasByIdPaymentVoucher(@Param("id") Long idPaymentVoucher);

}
