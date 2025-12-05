package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.EmailCompanyNotifyModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmailCompanyNotifyMapper extends BaseMapper<EmailCompanyNotifyModel, Long> {

    List<EmailCompanyNotifyModel> findAllByCompanyRucAndEstadoIsTrue(String ruc);

}
