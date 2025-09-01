package com.certicom.certifact_facturas_service_sp.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeFieldMapper {

    int getIdByName(String name);

}
