package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.RegisterFileUpload;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterFileUploadMapper {

    int registrarSubidaArchivo(RegisterFileUpload registerFileUpload);
    public SubidaRegistroArchivoEntity obtenerSubidaArchivoPorId(Long id);
    public RegisterFileUpload findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(
            @Param("id") Long idPayment, @Param("tipo") String tipoArchivo, @Param("estado") String estado
    );
    public RegisterFileUpload findByIdPaymentVoucherAndUuidTipo(Long id, String uuid, String tipo);

}
