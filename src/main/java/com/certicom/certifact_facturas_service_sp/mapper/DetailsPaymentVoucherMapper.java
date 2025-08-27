package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.ComprobanteItem;
import com.certicom.certifact_facturas_service_sp.entity.DetailsPaymentVoucherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface DetailsPaymentVoucherMapper {

    int registrarDetailsPaymentVoucher(ComprobanteItem detailsPaymentVoucher);
    int deleteDetailPaymentVoucherById(@Param("id") Long detailPaymentVoucherId);
    List<ComprobanteItem> findByIdPaymentVoucher(@Param("id") Long idPaymentVoucher);

}
