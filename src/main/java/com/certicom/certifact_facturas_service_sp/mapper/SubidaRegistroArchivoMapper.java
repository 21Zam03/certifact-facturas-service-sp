package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.RegisterFileUploadDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface SubidaRegistroArchivoMapper {

    int registrarSubidaArchivo(RegisterFileUploadDto registerFileUploadDto);
    public SubidaRegistroArchivoEntity obtenerSubidaArchivoPorId(Integer id);
    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(
            @Param("id") Long idPayment, @Param("tipo") String tipoArchivo, @Param("estado") String estado
    );

}
