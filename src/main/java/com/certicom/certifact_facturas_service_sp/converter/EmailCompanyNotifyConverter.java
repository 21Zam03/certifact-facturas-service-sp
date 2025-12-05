package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.dto.others.EmailCompanyNotifyDto;
import com.certicom.certifact_facturas_service_sp.model.EmailCompanyNotifyModel;

import java.util.List;
import java.util.stream.Collectors;

public class EmailCompanyNotifyConverter {

    public static EmailCompanyNotifyDto modelToDto(EmailCompanyNotifyModel emailCompanyNotifyModel) {
        return EmailCompanyNotifyDto.builder()
                .id(emailCompanyNotifyModel.getId())
                .email(emailCompanyNotifyModel.getEmail())
                .estado(emailCompanyNotifyModel.isEstado())
                .codCompany(emailCompanyNotifyModel.getCodCompany())
                .build();
    }

    public static List<EmailCompanyNotifyDto> modelListToDtoList(List<EmailCompanyNotifyModel> models) {
        if (models == null) {
            return null;
        }
        return models.stream()
                .map(EmailCompanyNotifyConverter::modelToDto)
                .collect(Collectors.toList());
    }

}
