package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.RegisterFileUpload;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;

public interface SubidaRegistroArchivoService {

    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(RegisterFileUpload registerFileUpload);
    public RegisterFileUpload findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc
            (Long idPayment, String tipoArchivo, String estadoArchivo);
    public RegisterFileUpload findByIdPaymentVoucherAndUuidTipo(Long id, String uuid, String tipo);
    public RegisterFileUpload findRegisterFileUpload(Long id);

}
