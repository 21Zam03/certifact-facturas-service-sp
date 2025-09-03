package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParameterMapper {

    Parameter findByName(String name);

}
