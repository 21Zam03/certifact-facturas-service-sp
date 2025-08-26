package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;

public class PaymentVoucherConverter {

    public static ComprobanteEntity toEntity(PaymentVoucherDto paymentVoucherInterDto) {
        return ComprobanteEntity.builder()
                .serie(paymentVoucherInterDto.getSerie())
                .numero(paymentVoucherInterDto.getNumero())
                .build();
    }

    public static PaymentVoucherDto entityToDto(PaymentVoucherEntity paymentVoucherEntity) {
        return PaymentVoucherDto.builder()
                .rucEmisor(paymentVoucherEntity.getRucEmisor())
                .tipoComprobante(paymentVoucherEntity.getTipoComprobante())
                .serie(paymentVoucherEntity.getSerie())
                .numero(paymentVoucherEntity.getNumero())
                .fechaEmision(paymentVoucherEntity.getFechaEmision())
                .horaEmision(paymentVoucherEntity.getHoraEmision())
                .fechaEmision(paymentVoucherEntity.getFechaEmision())
                .codigoMoneda(paymentVoucherEntity.getCodigoMoneda())
                .fechaVencimiento(paymentVoucherEntity.getFechaVencimiento())
                .codigoTipoOperacion(paymentVoucherEntity.getTipoOperacion())
                .tipoDocumentoReceptor(paymentVoucherEntity.getTipoDocIdentReceptor())
                .numeroDocumentoReceptor(paymentVoucherEntity.getNumDocIdentReceptor())
                .denominacionReceptor(paymentVoucherEntity.getDenominacionReceptor())
                .direccionReceptor(paymentVoucherEntity.getDireccionReceptor())
                .emailReceptor(paymentVoucherEntity.getEmailReceptor())
                .totalValorVentaGravada(paymentVoucherEntity.getTotalValorVentaOperacionGravada())
                .totalIgv(paymentVoucherEntity.getSumatoriaIGV())
                .importeTotalVenta(paymentVoucherEntity.getMontoImporteTotalVenta())
                .estadoSunat(paymentVoucherEntity.getEstadoSunat())
                .build();
    }
}
