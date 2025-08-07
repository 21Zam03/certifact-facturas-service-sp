package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.mapper.InvoiceMapper;
import com.certicom.certifact_facturas_service_sp.service.ComprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComprobanteServiceImpl implements ComprobanteService {

    private final InvoiceMapper invoiceMapper;

    @Override
    public List<PaymentVoucherInterDto> searchInvoiceByFilter(
            Long idUsuario, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer pageNumber, Integer perPage, Integer estadoSunat
    ) {
        PaymentVoucherFilterDto filtro = PaymentVoucherFilterDto.builder()
                .idUsuario(idUsuario)
                .filtroDesde(filtroDesde)
                .filtroHasta(filtroHasta)
                .filtroTipoComprobante(filtroTipoComprobante)
                .filtroRuc(filtroRuc)
                .filtroSerie(filtroSerie)
                .filtroNumero(filtroNumero)
                .pageNumber(pageNumber)
                .perPage(perPage)
                .estadoSunat(estadoSunat)
                .build();
        return invoiceMapper.findAllSearchForPages(filtro);
    }

    @Override
    public List<ComprobanteEntity> getAllPaymentVouchers() {
        return Collections.emptyList();
    }

}
