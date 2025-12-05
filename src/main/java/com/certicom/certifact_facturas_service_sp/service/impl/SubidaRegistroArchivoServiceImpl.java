package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.model.RegisterFileUpload;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.exceptions.ServiceException;
import com.certicom.certifact_facturas_service_sp.mapper.RegisterFileUploadMapper;
import com.certicom.certifact_facturas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_facturas_service_sp.service.SubidaRegistroArchivoService;
import org.springframework.stereotype.Service;

@Service
public class SubidaRegistroArchivoServiceImpl extends AbstractGenericService<RegisterFileUpload, Long, RegisterFileUploadMapper> implements SubidaRegistroArchivoService {

    private final RegisterFileUploadMapper registerFileUploadMapper;

    protected SubidaRegistroArchivoServiceImpl(RegisterFileUploadMapper mapper, RegisterFileUploadMapper registerFileUploadMapper) {
        super(mapper);
        this.registerFileUploadMapper = registerFileUploadMapper;
    }

    @Override
    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(RegisterFileUpload registerFileUpload) {
        registerFileUpload.setEstado("A");
        int result = registerFileUploadMapper.registrarSubidaArchivo(registerFileUpload);
        if(result < 1) {
            throw new ServiceException("Error al guardar el archivo en la base de datos");
        }
        return registerFileUploadMapper.obtenerSubidaArchivoPorId(registerFileUpload.getIdRegisterFileSend());
    }

    @Override
    public RegisterFileUpload findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(Long idPayment, String tipoArchivo, String estadoArchivo) {
        return registerFileUploadMapper.findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(idPayment, tipoArchivo, estadoArchivo);
    }

    @Override
    public RegisterFileUpload findByIdPaymentVoucherAndUuidTipo(Long id, String uuid, String tipo) {
        return registerFileUploadMapper.findByIdPaymentVoucherAndUuidTipo(id, uuid, tipo);
    }

    @Override
    public RegisterFileUpload findRegisterFileUpload(Long id) {
        return findById(id).get();
    }

}
