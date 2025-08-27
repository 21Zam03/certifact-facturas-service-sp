package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.CampoAdicional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdditionalFieldMapper {

    int registrarCampoAdicionalComprobante(CampoAdicional aditionalFieldEntity);
    int findAditionalFieldIdByValorCampo(String valorCampo);
    int deleteAditionalFieldPaymentById(@Param("id") Long aditionalFieldId);

}
