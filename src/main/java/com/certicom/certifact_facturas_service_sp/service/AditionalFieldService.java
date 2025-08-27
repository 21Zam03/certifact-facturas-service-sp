package com.certicom.certifact_facturas_service_sp.service;

public interface AditionalFieldService {

    int findAditionalFieldIdByValorCampo(String valorCampo);
    int deleteAditionalFieldPaymentById(Long aditionalFieldId);

}
