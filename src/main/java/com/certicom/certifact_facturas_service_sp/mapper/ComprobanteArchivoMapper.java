package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherFileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComprobanteArchivoMapper {

    int registrarComprobanteArchivo(PaymentVoucherFileEntity paymentVoucherFileEntity);

}
