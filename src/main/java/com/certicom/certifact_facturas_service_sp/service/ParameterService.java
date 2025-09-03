package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.Parameter;

public interface ParameterService {

    Parameter findByName(String name);

}
