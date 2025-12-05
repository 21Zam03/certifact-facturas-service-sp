package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.others.EmailCompanyNotifyDto;

import java.util.List;

public interface EmailCompanyNotifyService {

    List<EmailCompanyNotifyDto> findAllByCompanyRucAndEstadoIsTrue(String ruc);

}
