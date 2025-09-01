package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.RegisterFileUploadDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;

public interface SubidaRegistroArchivoService {

    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(RegisterFileUploadDto registerFileUploadDto);
    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc
            (Long idPayment, String tipoArchivo, String estadoArchivo);

}
