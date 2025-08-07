package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvoiceMapper {

    List<ComprobanteEntity> findAll();

    List<PaymentVoucherInterDto> findAllSearchForPages(@Param("filtro") PaymentVoucherFilterDto paymentVoucherFilterDto);

}
