package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.dto.model.SubidaRegistroArchivoDto;
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
    public SubidaRegistroArchivoEntity regitrarSubidaArchivo(SubidaRegistroArchivoDto subidaRegistroArchivoDto) {
        subidaRegistroArchivoDto.setEstado("A");
        int result = subidaRegistroArchivoMapper.registrarSubidaArchivo(subidaRegistroArchivoDto);
        if(result < 1) {
            throw new ServicioException("Error al guardar el archivo en la base de datos");
        }
        return subidaRegistroArchivoMapper.obtenerSubidaArchivoPorId(subidaRegistroArchivoDto.getId());
    }

}
