package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.CampoAdicional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdditionalFieldMapper {

    int registrarCampoAdicionalComprobante(CampoAdicional aditionalFieldEntity);
    int deleteAditionalFieldPaymentById(@Param("id") Long aditionalFieldId);
    List<CampoAdicional> listAditionalFieldByIdPaymentVoucher(Long idPaymentVoucher);

}
