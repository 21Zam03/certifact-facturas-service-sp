package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.converter.EmailCompanyNotifyConverter;
import com.certicom.certifact_facturas_service_sp.dto.others.EmailCompanyNotifyDto;
import com.certicom.certifact_facturas_service_sp.mapper.EmailCompanyNotifyMapper;
import com.certicom.certifact_facturas_service_sp.model.EmailCompanyNotifyModel;
import com.certicom.certifact_facturas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_facturas_service_sp.service.EmailCompanyNotifyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailCompanyNotifyServiceImpl extends AbstractGenericService<EmailCompanyNotifyModel, Long, EmailCompanyNotifyMapper> implements EmailCompanyNotifyService {

    protected EmailCompanyNotifyServiceImpl(EmailCompanyNotifyMapper mapper) {
        super(mapper);
    }

    @Override
    public List<EmailCompanyNotifyDto> findAllByCompanyRucAndEstadoIsTrue(String ruc) {
        List<EmailCompanyNotifyModel> emailsList = mapper.findAllByCompanyRucAndEstadoIsTrue(ruc);
        return EmailCompanyNotifyConverter.modelListToDtoList(emailsList);
    }

}
