package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;

public class PaymentVoucherConverter {

    public static ComprobanteEntity toEntity(PaymentVoucherModel paymentVoucherModelInterDto) {
        return ComprobanteEntity.builder()
                .serie(paymentVoucherModelInterDto.getSerie())
                .numero(paymentVoucherModelInterDto.getNumero())
                .build();
    }

    public static PaymentVoucherModel entityToDto(PaymentVoucherEntity paymentVoucherEntity) {
        return PaymentVoucherModel.builder()
                .idPaymentVoucher(paymentVoucherEntity.getIdPaymentVoucher())
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
