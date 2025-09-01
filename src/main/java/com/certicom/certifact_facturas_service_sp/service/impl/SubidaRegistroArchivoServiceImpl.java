package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.model.RegisterFileUploadDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.exceptions.ServicioException;
import com.certicom.certifact_facturas_service_sp.mapper.SubidaRegistroArchivoMapper;
import com.certicom.certifact_facturas_service_sp.service.SubidaRegistroArchivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubidaRegistroArchivoServiceImpl implements SubidaRegistroArchivoService {

    private final SubidaRegistroArchivoMapper subidaRegistroArchivoMapper;

    @Override
    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(RegisterFileUploadDto registerFileUploadDto) {
        registerFileUploadDto.setEstado("A");
        int result = subidaRegistroArchivoMapper.registrarSubidaArchivo(registerFileUploadDto);
        if(result < 1) {
            throw new ServicioException("Error al guardar el archivo en la base de datos");
        }
        return subidaRegistroArchivoMapper.obtenerSubidaArchivoPorId(registerFileUploadDto.getId());
    }

    @Override
    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(Long idPayment, String tipoArchivo, String estadoArchivo) {
        return subidaRegistroArchivoMapper.findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(idPayment, tipoArchivo, estadoArchivo);
    }

}
