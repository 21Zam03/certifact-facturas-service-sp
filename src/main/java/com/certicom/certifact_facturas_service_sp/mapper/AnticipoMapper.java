package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.others.Anticipo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnticipoMapper {

    int registrarAnticipo(Anticipo anticipo);

}
