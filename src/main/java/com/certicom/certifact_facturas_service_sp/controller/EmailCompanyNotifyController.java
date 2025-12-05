package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.others.EmailCompanyNotifyDto;
import com.certicom.certifact_facturas_service_sp.service.EmailCompanyNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EmailCompanyNotifyController.API_PATH)
public class EmailCompanyNotifyController {

    public final static String API_PATH = "/api/email-company-notify";
    private final EmailCompanyNotifyService emailCompanyNotifyService;

    @Autowired
    public EmailCompanyNotifyController(EmailCompanyNotifyService emailCompanyNotifyService) {
        this.emailCompanyNotifyService = emailCompanyNotifyService;
    }

    @GetMapping("join/ruc")
    ResponseEntity<List<EmailCompanyNotifyDto>> findAllByCompanyRucAndEstadoIsTrue(@RequestParam String ruc) {
        return new ResponseEntity<>(emailCompanyNotifyService.findAllByCompanyRucAndEstadoIsTrue(ruc), HttpStatus.OK);
    }

}
