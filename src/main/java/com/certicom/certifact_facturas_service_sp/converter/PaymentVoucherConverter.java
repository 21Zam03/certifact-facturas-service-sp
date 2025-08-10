package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.dto.model.ComprobanteInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;

public class PaymentVoucherConverter {

    public static ComprobanteEntity toEntity(ComprobanteInterDto paymentVoucherInterDto) {
        return ComprobanteEntity.builder()
                .serie(paymentVoucherInterDto.getSerie())
                .numero(paymentVoucherInterDto.getNumero())
                .build();
    }
}
